package com.docmatter.ims.setting;

import com.docmatter.ims.util.AppSettingUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeasuredOperationManager {

    private int seed;
    private AppSettings appSettings;

    private List<String> measuredOperationList;
    private Map<Integer, String> valueToMeasuredOperationReprMap;
    private Map<String, Integer> measuredOperationReprToValueMap;

    private static MeasuredOperationManager me = new MeasuredOperationManager();
    public MeasuredOperationManager(){
        seed = 1;
        try{
            appSettings = AppSettingUtil.getAppSettings();
        }catch (Exception e){
            e.printStackTrace();
        }
        valueToMeasuredOperationReprMap = new HashMap<>();
        measuredOperationReprToValueMap = new HashMap<>();
        measuredOperationList = new ArrayList<>();
        for(OperationSetting operationSetting: appSettings.getOperationSettings()){
            ActionTargetSetting actionTargetSetting = operationSetting.getActionTargetSetting();
            for(ActionSetting actionSetting: operationSetting.getActionSettings()){
                String temp = actionTargetSetting.getName() + "_" + actionSetting.getName();
                measuredOperationList.add(temp);
                valueToMeasuredOperationReprMap.put(seed, temp);
                measuredOperationReprToValueMap.put(temp, seed++);
            }
        }
    }

    public Map<Integer, String> getValueToMeasuredOperationReprMap(){
        return this.valueToMeasuredOperationReprMap;
    }
    public Map<String, Integer> getMeasuredOperationReprToValueMap(){
        return this.measuredOperationReprToValueMap;
    }

    public static MeasuredOperationManager me() {
        return me;
    }

}
