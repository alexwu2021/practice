package com.docmatter.ims.domain.model;

public class LogNotificationEmailView {
    private long emailToUid;
    private String viewDate;
    private long notificationEmailId;
    private String category;
    private long notificationId;

    public String getViewDate() {
        return viewDate;
    }

    public long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getNotificationEmailId() {
        return notificationEmailId;
    }

    public void setNotificationEmailId(long notificationEmailId) {
        this.notificationEmailId = notificationEmailId;
    }

    public void setViewDate(String viewDate) {
        this.viewDate = viewDate;
    }

    public long getEmailToUid() {
        return emailToUid;
    }

    public void setEmailToUid(int emailToUid) {
        this.emailToUid = emailToUid;
    }

    public String toImsString() {
        return this.emailToUid
                + "," + this.viewDate
                + "," + this.notificationEmailId
                + "," + this.category
                + "," + this.notificationId;
    }

    @Override
    public String toString() {
        return "LogNotificationEmailView{" +
                "emailToUid=" + emailToUid +
                ", viewDate='" + viewDate + '\'' +
                ", notificationEmailId=" + notificationEmailId +
                ", category=" + category +
                ", notificationId=" + notificationId +
                '}';
    }

}
