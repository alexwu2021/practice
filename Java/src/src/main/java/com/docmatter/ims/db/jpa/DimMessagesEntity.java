package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "dim_messages", schema = "dw", catalog = "")
public class DimMessagesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "message_id")
    private Integer messageId;
    @Basic
    @Column(name = "message_seq_num")
    private String messageSeqNum;
    @Basic
    @Column(name = "fact_uuid_hash")
    private int factUuidHash;
    @Basic
    @Column(name = "discussion_id")
    private Integer discussionId;
    @Basic
    @Column(name = "subject")
    private String subject;
    @Basic
    @Column(name = "transmission_type")
    private String transmissionType;
    @Basic
    @Column(name = "dt_created")
    private Date dtCreated;
    @Basic
    @Column(name = "prev_fact_uuid_hash")
    private Integer prevFactUuidHash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageSeqNum() {
        return messageSeqNum;
    }

    public void setMessageSeqNum(String messageSeqNum) {
        this.messageSeqNum = messageSeqNum;
    }

    public int getFactUuidHash() {
        return factUuidHash;
    }

    public void setFactUuidHash(int factUuidHash) {
        this.factUuidHash = factUuidHash;
    }

    public Integer getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Integer discussionId) {
        this.discussionId = discussionId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Integer getPrevFactUuidHash() {
        return prevFactUuidHash;
    }

    public void setPrevFactUuidHash(Integer prevFactUuidHash) {
        this.prevFactUuidHash = prevFactUuidHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimMessagesEntity that = (DimMessagesEntity) o;
        return id == that.id && factUuidHash == that.factUuidHash && Objects.equals(messageId, that.messageId) && Objects.equals(messageSeqNum, that.messageSeqNum) && Objects.equals(discussionId, that.discussionId) && Objects.equals(subject, that.subject) && Objects.equals(transmissionType, that.transmissionType) && Objects.equals(dtCreated, that.dtCreated) && Objects.equals(prevFactUuidHash, that.prevFactUuidHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageId, messageSeqNum, factUuidHash, discussionId, subject, transmissionType, dtCreated, prevFactUuidHash);
    }
}
