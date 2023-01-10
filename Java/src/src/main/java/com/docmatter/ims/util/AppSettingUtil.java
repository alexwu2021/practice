package com.docmatter.ims.util;

import com.docmatter.ims.setting.AppSettings;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;

public class AppSettingUtil {

    private static String jsonPath = "prod/appsettings.json";
    public static AppSettings getAppSettings()  {
        AppSettings appSettings = null;
        try{
            File file = ResourceUtils.getFile("classpath:" + jsonPath);
            System.out.println("in getAppSettings, file path : " + file.getPath());
            String jsonString = FileUtil.readAll(file);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
            appSettings = objectMapper.readValue(jsonString, AppSettings.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return appSettings;
    }
}
