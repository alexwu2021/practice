package com.docmatter.ims.domain.bizlogic.reducer;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.domain.model.ProcessingResult;
import com.docmatter.ims.exception.ImsException;
import com.docmatter.ims.util.MathUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class BaseReducer {
    private Date beginDate;
    private Date endDate;

    //private String reducerFileContainingFolder;
    private String resultingFileName;
    private String explodedFactFileContainingFolder;

    public BaseReducer(Integer beginDate, Integer endDate) {
        try {
            this.beginDate = MathUtil.convertToDate(beginDate.toString());
            this.endDate = MathUtil.convertToDate(endDate.toString());
        } catch(ParseException pe){
            pe.printStackTrace();
        }
        catch(ImsException ie) {
            ie.printStackTrace();
        }
        //this.reducerFileContainingFolder = ImsConstant.REDUCER_FILE_CONTAINING_FOLDER;
        this.explodedFactFileContainingFolder = ImsConstant.EXPLODED_FACT_FILE_OUTPUT_FOLDER;
        //this.resultingFileName = getReducerFilePathName();
    }
//
//    private String getReducerFilePathName() {
//        return this.reducerFileContainingFolder + "/" + this.beginDate + "_" + this.endDate + ImsConstant.REDUCER_FACT_FILE_EXT;
//    }

//    public File getReducerFile(Integer beginDate, Integer endDate) {
//        File file = new File(getReducerFilePathName());
//        return file;
//    }

    public ProcessingResult doReductionFor() {
        ProcessingResult ret = new ProcessingResult();
        final File folder = new File(this.explodedFactFileContainingFolder);
        List<String> list = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            String pureFileName = fileEntry.getName();
            try {
                Date intVal = MathUtil.getLocalDateFromIntegerString(pureFileName);
                if (intVal.compareTo(this.endDate) <= 0 && intVal.compareTo(this.beginDate) >= 0) {
                    list.add(pureFileName);
                }
            } catch (ImsException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        ret = doReductionFor(this.explodedFactFileContainingFolder, list);
        System.out.println("final result is " + ret.toString());
        return ret;
    }

    private ProcessingResult doReductionFor(String containingFolder, List<String> files) {
        ProcessingResult ret = new ProcessingResult();
        Map<String, Integer>mp = new HashMap<>();
        for(String file: files){
            processingSingleFile(containingFolder + file, mp);
            ret.appendToFinalResult(mp);
        }
        return ret;
    }

    private void processingSingleFile(String fileName, Map<String, Integer> mp) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                Long nugId = Long.valueOf(sa[0]);
                Long operationId = Long.valueOf(sa[1]);
                String key = nugId + "$" + operationId;
                mp.put(key, mp.getOrDefault(key, 0) + 1);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("done processingSingleFile for file " + fileName);
        }
    }
}