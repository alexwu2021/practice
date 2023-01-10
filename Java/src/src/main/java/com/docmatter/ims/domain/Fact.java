package com.docmatter.ims.domain;

import com.docmatter.ims.setting.MeasuredOperation;

public class Fact {

    private com.docmatter.ims.setting.MeasuredOperation measuredOperation;

    private Fact(){};

    private Long userSeq;
    public Fact(Long userSeq, MeasuredOperation operation){
        this.userSeq = userSeq;
        this.measuredOperation = operation;
    }

    public MeasuredOperation getMeasuredOperation(){
        return this.measuredOperation;
    }
    public void setMeasuredOperation(MeasuredOperation measuredOperation){
        this.measuredOperation = measuredOperation;
    }

    public Long getUserSeq(){
        return this.userSeq;
    }
    public void setUserSeq(Long userSeq){
        this.userSeq = userSeq;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "measuredOperation=" + measuredOperation +
                ", userSeq=" + userSeq +
                '}';
    }

    public String toImsString() {
        return userSeq + "," + measuredOperation.getId();
    }
}
