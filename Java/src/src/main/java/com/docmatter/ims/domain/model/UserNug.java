package com.docmatter.ims.domain.model;

public class UserNug {
    private int UID;
    private int nugId;

    public int getUID() {
        return UID;
    }

    @Override
    public String toString() {
        return "UserNug{" +
                "UID=" + UID +
                ", nugId=" + nugId +
                '}';
    }

    public int getNugId() {
        return nugId;
    }

    public void setNugId(int nugId) {
        this.nugId = nugId;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String toImsString() {
        return UID + "," + nugId;
    }


}
