package com.docmatter.ims.controller;


import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HealthMonitoringController {

    private static final Logger log = LoggerFactory.getLogger(HealthMonitoringController.class);
    private static String _healthMonitoringFile;

    static {
        try {
            _healthMonitoringFile = FileUtil.getAbsoluteFilePath(ImsConstant.HEALTH_MONITORING_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Value("${appConfig.numberOfLinesToReturnForHealthLog}")
    private int numberOfLinesToReturnForHealthLog;


    @GetMapping("/health/getReport")
    public List<String> getHealthReport() throws Exception {
        log.info("Inside HealthMonitoringController");

        try{
            List<String> ret = FileUtil.readNTailLinesFromAFile(_healthMonitoringFile, numberOfLinesToReturnForHealthLog);
            log.info("read " + ret.size() + " lines back from file " + _healthMonitoringFile);
            return ret;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}