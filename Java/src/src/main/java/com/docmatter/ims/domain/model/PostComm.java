package com.docmatter.ims.domain.model;

import com.docmatter.ims.util.DateTimeUtil;

public class PostComm {
    private int id;
    private int msId;
    private int ctxType;
    private int ctxId;
    private int type;
    private String createdDate;
    private int createdBy;
    private String lastModifiedDate;
    private int lastModifiedBy;
    private int accessCtxType;
    private int accessCtxId;
    private int mode;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getMsId(){
        return this.msId;
    }
    public void setMsId(int msId){
        this.msId = msId;
    }
    public int getCtxType(){
        return this.ctxType;
    }
    public void setCtxType(int ctxType){
        this.ctxType = ctxType;
    }
    public int getCtxId(){
        return this.ctxId;
    }
    public void setCtxId(int ctxId){
        this.ctxId = ctxId;
    }
    public int getType(){
        return this.type;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getMode(){
        return this.mode;
    }
    public void setMode(int mode){
        this.mode = mode;
    }
    public int getAccessCtxType(){
        return this.accessCtxType;
    }
    public void setAccessCtxType(int accessCtxType){
        this.accessCtxType = accessCtxType;
    }
    public int getAccessCtxId(){
        return this.accessCtxId;
    }
    public void setAccessCtxId(int accessCtxId){
        this.accessCtxId = accessCtxId;
    }
    public String getCreatedDate(){
        return this.createdDate;
    }
    public void setCreatedDate(String createdDate){
        this.createdDate = createdDate;
    }
    public String getLastModifiedDate(){ return this.lastModifiedDate;}
    public void setLastModifiedDate(String lastModifiedDate){
        this.lastModifiedDate = lastModifiedDate;
    }
    public int getCreatedBy(){
        return createdBy;
    }
    public void setCreatedBy(int createdBy){
        this.createdBy = createdBy;
    }
    public int getLastModifiedBy(){
        return this.lastModifiedBy;
    }
    public void setLastModifiedBy(int lastModifiedBy){
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String toString() {
        return "PostComm{" +
                "id=" + id +
                ", msId=" + msId +
                ", ctxType=" + ctxType +
                ", ctxId=" + ctxId +
                ", type=" + type +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", accessCtxType=" + accessCtxType +
                ", accessCtxId=" + accessCtxId +
                ", mode=" + mode +
                '}';
    }


    public String toImsString() {
        return
                "" + id +
                "," + msId +
                "," + ctxType +
                "," + ctxId +
                "," + type +
                "," + (createdDate != null ? createdDate : DateTimeUtil.getDefaultDateTimeString()) +
                "," + createdBy +
                "," + (lastModifiedDate != null ? lastModifiedDate : DateTimeUtil.getDefaultDateTimeString()) +
                "," + lastModifiedBy +
                "," + accessCtxType +
                "," + accessCtxId +
                "," + mode;
    }
}
