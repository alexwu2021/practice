package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dim_users", schema = "dw", catalog = "")
public class DimUsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "uid")
    private long uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimUsersEntity that = (DimUsersEntity) o;
        return id == that.id && uid == that.uid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid);
    }
}
