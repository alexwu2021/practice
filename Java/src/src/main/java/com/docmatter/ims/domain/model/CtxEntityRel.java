package com.docmatter.ims.domain.model;

import com.docmatter.ims.util.MathUtil;

public class CtxEntityRel {
    private int ctxTypeId;
    private int ctxId;

    private int ctxTypeIdTo;
    private int ctxIdTo;

    private int accessCtxTypeId;
    private int accessCtxId;

    public int getCtxTypeId(){
        return this.ctxTypeId;
    }
    public void setCtxTypeId(int val){
        this.ctxTypeId = val;
    }
    public int getCtxId(){
        return this.ctxId;
    }
    public void setCtxId(int val){
        this.ctxId = val;
    }

    public int getCtxTypeIdTo(){
        return this.ctxTypeIdTo;
    }
    public void setCtxTypeIdTo(int val){
        this.ctxTypeIdTo = val;
    }
    public int getCtxIdTo(){
        return this.ctxIdTo;
    }
    public void setCtxIdTo(int val){
        this.ctxIdTo = val;
    }

    public int getAccessCtxTypeId(){
        return this.accessCtxTypeId;
    }
    public void setAccessCtxTypeId(int accessCtxTypeId){
        this.accessCtxTypeId = accessCtxTypeId;
    }
    public int getAccessCtxId(){
        return this.accessCtxId;
    }
    public void setAccessCtxId(int accessCtxId){
        this.accessCtxId = accessCtxId;
    }



    @Override
    public String toString() {
        return "CtxEntityRel{" +
                "ctxTypeId=" + ctxTypeId +
                ", ctxId=" + ctxId +
                ", ctxTypeIdTo=" + ctxTypeIdTo +
                ", ctxIdTo=" + ctxIdTo +
                ", accessCtxTypeId=" + ctxTypeIdTo +
                ", accessCtxId=" + ctxIdTo +
                '}';
    }

    public String toImsString() {
        return ctxTypeId +
                "," + ctxId +
                "," + ctxTypeIdTo +
                "," + ctxIdTo +
                "," + ctxTypeIdTo +
                "," + ctxIdTo;
    }

    public String toEntityTo2SeqMappingString() {
        return ctxTypeIdTo +
                "," + ctxIdTo +
                "," +  MathUtil.encodeForEntity(ctxTypeId, ctxIdTo);
    }

    public String toAccessEntity2SeqMappingString() {
        return accessCtxTypeId +
                "," + accessCtxId +
                "," +  MathUtil.encodeForEntity(accessCtxTypeId, accessCtxId);
    }

}
