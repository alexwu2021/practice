package com.docmatter.ims;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.domain.bizlogic.factfileprocessing.OutputToExplodedFactFile;
import com.docmatter.ims.domain.bizlogic.rawfileprocessing.OutputToFactFile;
import com.docmatter.ims.util.FileUtil;
import com.docmatter.ims.util.ReducerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

public class BulkDataProcessor {

    private static final Logger log = LoggerFactory.getLogger(BulkDataProcessor.class);


    private static BulkDataProcessor me = new BulkDataProcessor();
    public static BulkDataProcessor me(){
        return me;
    }

    public void processBulkData() throws FileNotFoundException {
        System.out.println("--------[starting full run for processing bulk data ...");
        cleanUpAllFactFileFolderAndExplodedFactFileFolders();
        //cleanUpAllFoldersExceptInputFolders();

        OutputToFactFile outputToFactFiles = new OutputToFactFile(FileUtil.getAbsoluteFilePath(ImsConstant.INPUT_FILE_FOLDER),
                FileUtil.getAbsoluteFilePath(ImsConstant.FACT_FILE_OUTPUT_FOLDER));
        OutputToExplodedFactFile outputToExplodedFactFile = new OutputToExplodedFactFile(FileUtil.getAbsoluteFilePath(ImsConstant.FACT_FILE_OUTPUT_FOLDER),
                FileUtil.getAbsoluteFilePath(ImsConstant.EXPLODED_FACT_FILE_OUTPUT_FOLDER));
        try {
            // process the input data files and write to fact files
            outputToFactFiles.processAllFiles();

            // process the fact files and write to exploded fact files
            outputToExplodedFactFile.processAllFiles();

            runReducer();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("------done full run for processing bulk data]\n\n");
        }
    }


    private void cleanUpAllFoldersExceptInputFolders() throws FileNotFoundException {
        //cleanUpInputFolder();
        cleanUpAllFactFileFolderAndExplodedFactFileFolders();
        cleanUpGeneratedReferenceDataFolders();
        System.out.println("done cleanUpAllFoldersExceptInputFolders");
    }

    public void cleanUpAllFolders() throws FileNotFoundException {
        cleanUpInputFolder();
        cleanUpAllFactFileFolderAndExplodedFactFileFolders();
        cleanReferenceBaseFolder();
        cleanUpGeneratedReferenceDataFolders();
        System.out.println("done cleanUpAllFolders");
    }

    private void cleanReferenceBaseFolder() throws FileNotFoundException {
        String[] sa = new String[]{FileUtil.getAbsoluteFilePath(ImsConstant.REFERENCE_DATA_CONTAINING_FOLDER_BASE)};
        for(String s: sa){
            FileUtil.cleanupOutputFolder(s, true);
        }
        System.out.println("done cleanReferenceBaseFolder");
    }

    private void cleanUpAllFactFileFolderAndExplodedFactFileFolders() throws FileNotFoundException {
        String[] sa = new String[]{FileUtil.getAbsoluteFilePath(ImsConstant.FACT_FILE_OUTPUT_FOLDER), FileUtil.getAbsoluteFilePath(ImsConstant.EXPLODED_FACT_FILE_OUTPUT_FOLDER)};
        for(String s: sa){
            FileUtil.cleanupOutputFolder(s, false);
        }
        System.out.println("done cleanUpAllFactFileFolderAndExplodedFactFileFolders");
    }

    private void cleanUpInputFolder() throws FileNotFoundException {
        String[] sa = new String[]{FileUtil.getAbsoluteFilePath(ImsConstant.INPUT_FILE_FOLDER)};
        for(String s: sa){
            FileUtil.cleanupOutputFolder(s, true);
        }
        System.out.println("done cleanUpInputFolder");
    }
    private void cleanUpGeneratedReferenceDataFolders() throws FileNotFoundException {
        String[] sa = new String[]{
                FileUtil.getAbsoluteFilePath(ImsConstant.REFERENCE_DATA_CONTAINING_FOLDER_COMPUTED)
        };
        for(String s: sa){
            FileUtil.cleanupOutputFolder(s, false);
        }
        System.out.println("done cleanUpGeneratedReferenceDataFolders");
    }


    private void runReducer() {
        Integer beginDate = 20210101;
        Integer endDate = 20211231;
        ReducerUtil.runReducer(beginDate, endDate);
    }

}
