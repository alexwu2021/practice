package com.docmatter.ims.domain.model;

public class NotificationCtxMessage {
    private int notifcationId;
    private int msId;
    private String createdDate;


    public int getMsId(){
        return this.msId;
    }
    public void setMsId(int msId){
        this.msId = msId;
    }
    public int getNotifcationId(){
        return this.notifcationId;
    }
    public void setNotifcationId(int notifcationId){
        this.notifcationId = notifcationId;
    }
    public String getCreatedDate(){
        return this.createdDate;
    }
    public void setCreatedDate(String createdDate){
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "NotificationCtxMessage{" +
                "notifcationId=" + notifcationId +
                ", msId=" + msId +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }

    public String toImsString() {
        return notifcationId + "," + msId + "," + createdDate ;
    }
}
