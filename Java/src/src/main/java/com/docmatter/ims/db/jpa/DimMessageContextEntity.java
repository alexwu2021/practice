package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "dim_message_context", schema = "dw", catalog = "")
public class DimMessageContextEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "nick_name")
    private String nickName;
    @Basic
    @Column(name = "message_id")
    private int messageId;
    @Basic
    @Column(name = "nug_ids")
    private String nugIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getNugIds() {
        return nugIds;
    }

    public void setNugIds(String nugIds) {
        this.nugIds = nugIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimMessageContextEntity that = (DimMessageContextEntity) o;
        return id == that.id && messageId == that.messageId && Objects.equals(date, that.date) && Objects.equals(nickName, that.nickName) && Objects.equals(nugIds, that.nugIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, nickName, messageId, nugIds);
    }
}
