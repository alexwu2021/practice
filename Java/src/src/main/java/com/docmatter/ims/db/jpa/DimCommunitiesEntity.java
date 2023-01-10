package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dim_communities", schema = "dw", catalog = "")
public class DimCommunitiesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nug_id")
    private long nugId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNugId() {
        return nugId;
    }

    public void setNugId(long nugId) {
        this.nugId = nugId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimCommunitiesEntity that = (DimCommunitiesEntity) o;
        return id == that.id && nugId == that.nugId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nugId);
    }
}
