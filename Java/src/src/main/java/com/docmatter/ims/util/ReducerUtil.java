package com.docmatter.ims.util;

import com.docmatter.ims.domain.bizlogic.reducer.BaseReducer;
import com.docmatter.ims.domain.model.ProcessingResult;

import java.util.Map;

public class ReducerUtil {

    public static String runReducer(Integer beginDate, Integer endDate) {
        StringBuilder sb = new StringBuilder();
        System.out.println("staring reducer run for begin date: " + beginDate + "; end date: " + endDate + " ...");
        BaseReducer baseReducer = new BaseReducer(beginDate, endDate);
        ProcessingResult processingResult = baseReducer.doReductionFor();
        Map<String, Integer> mp = processingResult.getFinalResult();
        for(String key :  mp.keySet()){
            if(mp.getOrDefault(key, 0) > 0 ){
                System.out.println("key: " + key + ", count: " + mp.get(key));
                sb.append(key + " : " + mp.get(key) + ",\t");
            }
        }
        System.out.print("done reducer for run for begin date: " + beginDate + "; end date: " + endDate + ".");
        sb.append("\ndone the reducer job.");
        return sb.toString();
    }
}
