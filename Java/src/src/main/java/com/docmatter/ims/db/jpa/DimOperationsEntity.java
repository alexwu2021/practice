package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dim_operations", schema = "dw", catalog = "")
public class DimOperationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "action_target_id")
    private int actionTargetId;
    @Basic
    @Column(name = "action_id")
    private int actionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActionTargetId() {
        return actionTargetId;
    }

    public void setActionTargetId(int actionTargetId) {
        this.actionTargetId = actionTargetId;
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DimOperationsEntity that = (DimOperationsEntity) o;
        return id == that.id && actionTargetId == that.actionTargetId && actionId == that.actionId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actionTargetId, actionId);
    }
}
