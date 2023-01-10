package com.docmatter.ims.domain.model;

import com.docmatter.ims.util.DateTimeUtil;

public class CtxMessage {
    private int msId;
    private int ctxTypeId;
    private int ctxId;
    private int level;
    private int MsgType;
    private int state;
    private int threadMsId;
    private String createdDate;


    public int getMsId(){
        return this.msId;
    }
    public void setMsId(int val){
        this.msId = val;
    }

    public int getCtxTypeId(){
        return this.ctxTypeId;
    }
    public void setCtxTypeId(int ctxTypeId){
        this.ctxTypeId = ctxTypeId;
    }
    public int getCtxId(){
        return this.ctxId;
    }
    public void setCtxId(int ctxId){
        this.ctxId = ctxId;
    }

    public int getLevel(){
        return this.level;
    }
    public void setLevel(int val){
        this.level = val;
    }

    public int getMsgType(){
        return this.MsgType;
    }
    public void setMsgType(int val){
        this.MsgType = val;
    }

    public int getState(){
        return this.state;
    }
    public void setState(int val){
        this.state = val;
    }

    public int getThreadMsId(){
        return this.threadMsId;
    }
    public void setThreadMsId(int val){
        this.threadMsId = val;
    }


    public String getCreatedDate(){
        return this.createdDate;
    }
    public void setCreatedDate(String localDate){
        this.createdDate = localDate;
    }

    @Override
    public String toString() {
        return "CtxMessage{" +
                "msId=" + msId +

                ", ctxTypeId=" + ctxTypeId +
                ", ctxId=" + ctxId +

                ", level=" + level +
                ", MsgType=" + MsgType +
                ", state=" + state +
                ", threadMsId=" + threadMsId +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

    public String toImsString() {
        return msId +
                "," + ctxTypeId +
                "," + ctxId +
                "," + level +
                "," + MsgType +
                "," + state  +
                "," + threadMsId +
                "," + (createdDate != null ? createdDate : DateTimeUtil.getDefaultDateTimeString());
    }
}
