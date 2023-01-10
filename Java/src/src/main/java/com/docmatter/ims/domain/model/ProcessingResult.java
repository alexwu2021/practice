package com.docmatter.ims.domain.model;

import java.util.HashMap;
import java.util.Map;

public class ProcessingResult {
    private ProcessingErrorCodeEnum errorCode;
    private String errorMessage;
    private Map<String, Integer> finalResult = new HashMap<>();

    public ProcessingErrorCodeEnum getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(ProcessingErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Map<String, Integer> getFinalResult(){
        return this.finalResult;
    }

    public void setFinalResult(Map<String, Integer> mp){
        this.finalResult.clear();
        appendToFinalResult(mp);
    }

    public void appendToFinalResult(Map<String, Integer> mp){
        for(Map.Entry<String,Integer> entry:  mp.entrySet()){
            this.finalResult.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "ProcessingResult{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", finalResult has a size of " + finalResult.size() +
                '}';
    }
}
