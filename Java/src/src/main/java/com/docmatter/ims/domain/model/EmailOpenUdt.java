package com.docmatter.ims.domain.model;

import com.docmatter.ims.util.ImsStringUtil;
import com.google.common.base.Strings;

public class EmailOpenUdt {

    private int NOTIFICATION_EMAIL_ID;
    private int EMAIL_TO_UID;
    private String VIEW_DATE;
    private int msid;
    private int ctxtype;
    private int ctxid;
    private int access_ctxtype;
    private int access_ctxid;
    private int THREAD_MSID;
   // private int USER_TYPE;

//    public String getFULL_NAME() {
//        return FULL_NAME;
//    }
//
//    public void setFULL_NAME(String FULL_NAME) {
//        this.FULL_NAME = FULL_NAME;
//    }

//    public int getUSER_TYPE() {
//        return USER_TYPE;
//    }
//
//    public void setUSER_TYPE(int USER_TYPE) {
//        this.USER_TYPE = USER_TYPE;
//    }
//
//    private String FULL_NAME;

    public int getAccess_ctxid() {
        return access_ctxid;
    }

    public void setAccess_ctxid(int access_ctxid) {
        this.access_ctxid = access_ctxid;
    }

    public int getAccess_ctxtype() {
        return access_ctxtype;
    }

    public int getTHREAD_MSID() {
        return THREAD_MSID;
    }

    public void setTHREAD_MSID(int THREAD_MSID) {
        this.THREAD_MSID = THREAD_MSID;
    }

    public void setAccess_ctxtype(int access_ctxtype) {
        this.access_ctxtype = access_ctxtype;
    }

    public int getCtxid() {
        return ctxid;
    }

    public void setCtxid(int ctxid) {
        this.ctxid = ctxid;
    }

    public int getCtxtype() {
        return ctxtype;
    }

    public void setCtxtype(int ctxtype) {
        this.ctxtype = ctxtype;
    }

    public String getVIEW_DATE() {
        return VIEW_DATE;
    }

    public void setVIEW_DATE(String VIEW_DATE) {
        this.VIEW_DATE = VIEW_DATE;
    }

    public int getEMAIL_TO_UID() {
        return EMAIL_TO_UID;
    }

    public void setEMAIL_TO_UID(int EMAIL_TO_UID) {
        this.EMAIL_TO_UID = EMAIL_TO_UID;
    }

    public int getNOTIFICATION_EMAIL_ID() {
        return NOTIFICATION_EMAIL_ID;
    }

    public void setNOTIFICATION_EMAIL_ID(int NOTIFICATION_EMAIL_ID) {
        this.NOTIFICATION_EMAIL_ID = NOTIFICATION_EMAIL_ID;
    }

    public int getMsid() {
        return msid;
    }

    public void setMsid(int msid) {
        this.msid = msid;
    }

    @Override
    public String toString() {
        return "EmailOpenUdt{" +
                "NOTIFICATION_EMAIL_ID=" + NOTIFICATION_EMAIL_ID +
                ", EMAIL_TO_UID=" + EMAIL_TO_UID +
                ", VIEW_DATE='" + VIEW_DATE + '\'' +
                ", msid=" + msid +
                ", ctxtype=" + ctxtype +
                ", ctxid=" + ctxid +
                ", access_ctxtype=" + access_ctxtype +
                ", access_ctxid=" + access_ctxid +
                ", THREAD_MSID=" + THREAD_MSID +
//                ", USER_TYPE=" + USER_TYPE +
//                ", FULL_NAME='" + FULL_NAME + '\'' +
                '}';
    }

    public String toImsString() {
        return NOTIFICATION_EMAIL_ID +
                "," + EMAIL_TO_UID +
                "," + VIEW_DATE +
                "," + msid +
                "," + ctxtype +
                "," + ctxid +
                "," + access_ctxtype +
                "," + access_ctxid +
                "," + THREAD_MSID ;
                //"," + USER_TYPE +
                //"," +
                //((!Strings.isNullOrEmpty(FULL_NAME)) ? ImsStringUtil.treatItToBeOneLiner(FULL_NAME) : "unknown") ;

    }
}
