package com.docmatter.ims.domain.bizlogic.factfileprocessing;

import com.docmatter.ims.cache.ReferenceDataManager;
import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.domain.bizlogic.OutputToFile;
import com.docmatter.ims.util.FileUtil;
import com.docmatter.ims.util.FileWriterPool;
//import com.docmatter.util.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

public class OutputToExplodedFactFile extends OutputToFile {

    private FileWriterPool _fileWriterPool;
    private static String SPLITTER = ",";

    private String _sourceContainingFolder;
    private String _outputContainingFolder;

    //TODO: Will provide valueOf or Of method

    public OutputToExplodedFactFile(String sourceContainingFolder, String outputContainingFolder) {
        _fileWriterPool = new FileWriterPool();
        this._sourceContainingFolder = sourceContainingFolder;
        this._outputContainingFolder = outputContainingFolder;
        FileUtil.cleanupOutputFolder(this._outputContainingFolder, false);
    }


    public void processAllFiles() throws FileNotFoundException, JsonProcessingException {
        final File folder = new File(this._sourceContainingFolder);;
        for (final File fileEntry : folder.listFiles()) {
            processOneFile(fileEntry);
        }
    }

    private synchronized void processOneFile(File sourceFile) {
        String line = "";
        try {
            String resultingExplodedFileName = FileUtil.getResultingExplodedFileName(sourceFile.getName());
            FileUtil.deleteIfExistsAndReCreate(resultingExplodedFileName);

            BufferedWriter bufferedWriter = null;
            Writer fstream = null;
            BufferedWriter out = null;
            int defaultCharBufferSize = 100_000;
            fstream = new OutputStreamWriter(new FileOutputStream(resultingExplodedFileName, false), StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(fstream, defaultCharBufferSize);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
            line = bufferedReader.readLine();
            Map<Long, Set<Long>> user2NugMap = ReferenceDataManager.me().getUserId2NugIdSetMap();
            StringBuilder sb = new StringBuilder();
            while (line !=null && line.length() > 0 ) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                Long userSeq = Long.valueOf(sa[0]);
                if(user2NugMap.containsKey(userSeq)){
                    Set<Long> curr = user2NugMap.get(userSeq);
                    for(Long child : curr){
                        sb.append(child + "," + sa[1] + "\n");
                    }
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch(NumberFormatException nfe){
            if(line !=null && line.length() > 0 )
                System.out.println("in processOneFile, exception encountered when processing  " + line);
            else
                System.out.println("in processOneFile, exception encountered, line is empty or null");
            nfe.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("processed file %s", sourceFile.getAbsolutePath()));
        }
    }
}
