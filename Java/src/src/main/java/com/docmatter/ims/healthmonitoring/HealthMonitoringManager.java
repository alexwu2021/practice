package com.docmatter.ims.healthmonitoring;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.util.FileUtil;

import java.io.*;
import java.util.*;

public class HealthMonitoringManager {
    private static String _healthMonitoringFile = ImsConstant.HEALTH_MONITORING_FILE;
    private List<String> messages;
    private static HealthMonitoringManager me = new HealthMonitoringManager();
    public HealthMonitoringManager() {
        this.messages = new ArrayList<>();
    }

    public static HealthMonitoringManager me(){
        return me;
    }

    public void writeToHealthMonitoringLogFile(){
        StringBuilder sb = new StringBuilder();
        getFileCount(sb, ImsConstant.INPUT_FILE_FOLDER);
        getFileCount(sb, ImsConstant.REFERENCE_DATA_CONTAINING_FOLDER_BASE);
        getFileCount(sb, ImsConstant.REFERENCE_DATA_CONTAINING_FOLDER_COMPUTED);
        getFileCount(sb, ImsConstant.FACT_FILE_OUTPUT_FOLDER);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(_healthMonitoringFile), "UTF-8"));
            writer.write(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("in writeToHealthMonitoringLogFile, wrote to file " + _healthMonitoringFile);
        }

    }
    private void getFileCount(StringBuilder sb, String dataInput) {
        sb.append(FileUtil.getFileCountUnderAFolder(dataInput));
    }
}
