package com.docmatter.ims.domain.model;

public class ProductGroup {
    private int ctxTypeId;
    public int getCtxTypeId(){
        return this.ctxTypeId;
    }
    public void setCtxTypeId(int val){
        this.ctxTypeId = val;
    }

    private int ctxId;
    public int getCtxId(){
        return this.ctxId;
    }
    public void setCtxId(int val){
        this.ctxId = val;
    }

    @Override
    public String toString() {
        return "CtxEntity{" +
                "ctxTypeId=" + ctxTypeId +
                ", ctxId=" + ctxId +
                '}';
    }
    public String toImsString() {
        return ctxTypeId +
                "," + ctxId;
    }
}
