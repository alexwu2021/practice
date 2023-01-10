package com.docmatter.ims.domain.model;


import com.docmatter.ims.util.ImsStringUtil;
import com.docmatter.ims.util.MathUtil;
import com.google.common.base.Strings;

public class CtxEntity {

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

    private int state;
    public int getState(){
        return this.state;
    }
    public void setState(int val){
        this.state = val;
    }

    // we know there are some records whose name each is null or empty
    // the number of incidence is very small, only 8 for the test data set
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    private int uid;

    @Override
    public String toString() {
        return "CtxEntity{" +
                "ctxTypeId=" + ctxTypeId +
                ", ctxId=" + ctxId +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", uid=" + uid +
                '}';
    }

    public String toImsString() {
        return ctxTypeId +
                "," + ctxId +
                "," + state +
                "," +  ((!Strings.isNullOrEmpty(name)) ? ImsStringUtil.treatItToBeOneLiner(name) : "unknown")
                +"," + uid;
    }

    public String toEntityMappingReadyString() {
        return ctxTypeId +
                "," + ctxId +
                "," +  MathUtil.encodeForEntity(ctxTypeId, ctxId);
    }
}
