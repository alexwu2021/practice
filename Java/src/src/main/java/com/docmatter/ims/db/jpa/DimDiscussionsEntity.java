package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "dim_discussions", schema = "dw", catalog = "")
public class DimDiscussionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "discussion_id")
    private int discussionId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "thread_msid")
    private Integer threadMsid;
    @Basic
    @Column(name = "first_message_id")
    private Integer firstMessageId;
    @Basic
    @Column(name = "dt_created")
    private Date dtCreated;
    @Basic
    @Column(name = "status")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getThreadMsid() {
        return threadMsid;
    }

    public void setThreadMsid(Integer threadMsid) {
        this.threadMsid = threadMsid;
    }

    public Integer getFirstMessageId() {
        return firstMessageId;
    }

    public void setFirstMessageId(Integer firstMessageId) {
        this.firstMessageId = firstMessageId;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimDiscussionsEntity that = (DimDiscussionsEntity) o;
        return id == that.id && discussionId == that.discussionId && Objects.equals(name, that.name) && Objects.equals(threadMsid, that.threadMsid) && Objects.equals(firstMessageId, that.firstMessageId) && Objects.equals(dtCreated, that.dtCreated) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discussionId, name, threadMsid, firstMessageId, dtCreated, status);
    }
}
