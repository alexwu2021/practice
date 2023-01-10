package com.docmatter.ims.domain.bizlogic.rawfileprocessing;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.domain.Fact;
import com.docmatter.ims.domain.model.RawFileEnum;
import com.docmatter.ims.domain.bizlogic.OutputToFile;
import com.docmatter.ims.util.FactUtil;
import com.docmatter.ims.util.FileUtil;
import com.docmatter.ims.util.FileWriterPool;
import com.docmatter.ims.util.MathUtil;
//import com.docmatter.util.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OutputToFactFile extends OutputToFile {
    private static final Logger log = LoggerFactory.getLogger(OutputToFactFile.class);
    private static int _BestEffortMaxNumberOfRetry = 3;
    private static String OPEN_EMAIL =  "email" + "_" + "view";

    private FileWriterPool _fileWriterPool;
    private String _sourceContainingFolder;
    private String _outputContainingFolder;
    private Map<String, RawFileEnum>_nameToRawFileEnum;
    private Map<String, Integer> reprToMeasuredOperationIdMap;
    //TODO: Will provide valueOf or Of method

    public OutputToFactFile(String sourceContainingFolder, String outputContainingFolder){
        _fileWriterPool = new FileWriterPool();
        this._sourceContainingFolder = sourceContainingFolder;
        this._outputContainingFolder = outputContainingFolder;

        FileUtil.cleanupOutputFolder(this._outputContainingFolder, false);

        _nameToRawFileEnum = new HashMap<>();
        _nameToRawFileEnum.put(Paths.get(ImsConstant.EMAIL_OPEN_UDT_INPUT_FILE).getFileName().toString(),
                RawFileEnum.emailOpenUdt);
        // _nameToRawFileEnum.put(Paths.get(ImsConstant.POST_COMM_INPUT_FILE).getFileName().toString(), RawFileEnum.postcomm);

        reprToMeasuredOperationIdMap = new HashMap<>();
    }

    public void processAllFiles() throws FileNotFoundException, JsonProcessingException {
        final File folder = new File(this._sourceContainingFolder);;
        for (final File fileEntry : folder.listFiles()) {
            processOneFile(folder, fileEntry.getName());
        }
    }

    private void processOneFile(File containingFolder, String fileName) throws FileNotFoundException, JsonProcessingException {
        RawFileEnum rawFileEnum = this._nameToRawFileEnum.getOrDefault(fileName, RawFileEnum.unknown);
        if(rawFileEnum == RawFileEnum.unknown){
            System.out.println(String.format("Invalid file name %s, no operation in this scope.", fileName)) ;
            return;
        }
        processOneFile(rawFileEnum, _sourceContainingFolder.concat("/" + fileName));
    }


    private void processOneFile(RawFileEnum rawFileEnum, String file) throws FileNotFoundException, JsonProcessingException {

        switch (rawFileEnum){
//            case postcomm:
//                System.out.println("to parse into fact files for post_comm");
//                parsePostCommFileAndWriteToFactFile(rawFileEnum, file);
//                break;
//            case ctxmessage:
//                System.out.println("to parse into fact files for ctxmessage");
//                parseCtxMessageFileAndWriteToFactFile(rawFileEnum, file);
//                break;
            case emailOpenUdt:
                parseEmailOpenUdtFileAndWriteToFactFile(rawFileEnum, file);
            default: break;
        }
        this._fileWriterPool.close();
    }


    private Integer getOperationId(String repr){
        if(reprToMeasuredOperationIdMap.containsKey(repr))
            return reprToMeasuredOperationIdMap.get(repr);
        reprToMeasuredOperationIdMap.put(repr, getOperationService().getMappedValueByMeasuredOperationRepr(repr));
        return reprToMeasuredOperationIdMap.get(repr);
    }


    /**
     *
     *                 NOTIFICATION_EMAIL_ID +
     *                 "," + EMAIL_TO_UID +
     *                 "," + VIEW_DATE +
     *                 "," + ctxtype +
     *                 "," + ctxid +
     *                 "," + access_ctxtype +
     *                 "," + access_ctxid +
     *                 "," + THREAD_MSID ;
     *
     * @param rawFileEnum
     * @param file
     */
    private void parseEmailOpenUdtFileAndWriteToFactFile(RawFileEnum rawFileEnum, String file) {
        int lineCount = 0;
        Set<String> uniqueFiles = new HashSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();

            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);

                // 10010,20210902,Daily Digest,2268433
                String viewDateFactFileName = sa[2]; //view date
                Long userSeq = Long.valueOf(sa[1]);
                String createdDateFactFilePath = this._outputContainingFolder + viewDateFactFileName + ".fac";
                uniqueFiles.add(viewDateFactFileName);

                Integer measuredOperationId  = getOperationId(OPEN_EMAIL);
                Fact fact = FactUtil.convertToFact(userSeq, measuredOperationId);

                File factFile = new File(createdDateFactFilePath);
                Writer w;
                int count = 0;
                do{
                    count++;
                    w = this._fileWriterPool.getWriter(factFile);
                    if(w != null){
                        w.write(fact.toImsString() + "\n");
                        break;
                    } else {
                        continue;
                    }
                } while(count <= _BestEffortMaxNumberOfRetry);

                if(count > _BestEffortMaxNumberOfRetry){
                    String msg = "Warning: fact file leakage possible, as the count " + count + " is bigger than _BestEffortMaxNumberOfRetry of " + _BestEffortMaxNumberOfRetry;
                    System.out.println(msg);
                    log.warn(msg);
                }

                lineCount++;
                if(lineCount % 10000 == 0){
                    System.out.println("+++ processing line " + lineCount + " in parseEmailOpenUdtFileAndWriteToFactFile");
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("++++++++" + lineCount + " lines processed in parseEmailOpenUdtFileAndWriteToFactFile, and" + uniqueFiles.size()  + " fact files generated.");
        }
    }

    private void parsePostCommFileAndWriteToFactFile(RawFileEnum rawFileEnum, String file) {
        try {
            BufferedReader freader = new BufferedReader(new FileReader(file));
            String line = freader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                String createdDateFactFileName = sa[5]; //created date

                String lastModifiedDateFactFileName = sa[7]; //last updated date

                Long userSeq = MathUtil.encodeForEntity(Integer.valueOf(sa[2]), Integer.valueOf(sa[3]));

                String createdDateFactFilePath = this._outputContainingFolder + "/" + createdDateFactFileName + ".fac";
                String lastUpdatedDateFactFilePath = this._outputContainingFolder + "/" + lastModifiedDateFactFileName + ".fac";


                //TODO: need to do checking here to determine the right MeasuredOperation

                String repr = "email" + "_" + "create";
                Integer measuredOperationId  = getOperationService().getMappedValueByMeasuredOperationRepr(repr);
                Fact fact = FactUtil.convertToFact(userSeq, measuredOperationId);
                this._fileWriterPool.getWriter(new File(createdDateFactFilePath)).write(fact.toString() + "\n");

                repr = "email" + "_" + "update";
                measuredOperationId  = getOperationService().getMappedValueByMeasuredOperationRepr(repr);
                fact = FactUtil.convertToFact(userSeq, measuredOperationId);
                this._fileWriterPool.getWriter(new File(lastUpdatedDateFactFilePath)).write(fact.toString() + "\n");

                line = freader.readLine();
            }
            freader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void parseCtxMessageFileAndWriteToFactFile(RawFileEnum rawFileEnum, String file) {
        try {
            BufferedReader freader = new BufferedReader(new FileReader(file));
            String line = freader.readLine();
            while (line != null && line.length() > 0 ) {
                String[] temp = line.split(ImsConstant.SPLITTER);
                String factFileName = temp[7];
                Long userSeq = MathUtil.encodeForEntity(Integer.valueOf(temp[1]), Integer.valueOf(temp[2]));
                String path = this._outputContainingFolder + "/" + factFileName + ".fac";

                //TODO: need to do checking here to determine the right MeasuredOperation
                String repr = "email" + "_" + "create";
                Integer measuredOperationId  = getOperationService().getMappedValueByMeasuredOperationRepr(repr);
                Fact fact = FactUtil.convertToFact(userSeq, measuredOperationId);
                this._fileWriterPool.getWriter(new File(path)).write(fact.toString() + "\n");
                if(fact.getUserSeq() < 100000){
                    System.out.println(fact);
                }
                line = freader.readLine();
            }
            freader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
