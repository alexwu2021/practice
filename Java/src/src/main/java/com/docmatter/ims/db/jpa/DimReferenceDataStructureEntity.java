package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dim_reference_data_structure", schema = "dw", catalog = "")
public class DimReferenceDataStructureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "date_id")
    private int dateId;

    @Basic
    @Column(name = "uid")
    private long uid;
    @Basic
    @Column(name = "nug_ids")
    private String nugIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }



    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
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
        DimReferenceDataStructureEntity that = (DimReferenceDataStructureEntity) o;
        return id == that.id && dateId == that.dateId && uid == that.uid
                 && Objects.equals(nugIds, that.nugIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateId, uid, nugIds);
    }
}
