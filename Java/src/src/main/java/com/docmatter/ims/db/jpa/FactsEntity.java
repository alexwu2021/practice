package com.docmatter.ims.db.jpa;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "facts", schema = "dw", catalog = "")
public class FactsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fact_uuid_hash")
    private int factUuidHash;
    @Basic
    @Column(name = "action_user_id")
    private long actionUserId;
    @Basic
    @Column(name = "reference_data_structure_id")
    private Integer referenceDataStructureId;
    @Basic
    @Column(name = "event_date_id")
    private int eventDateId;
    @Basic
    @Column(name = "operation_id")
    private Integer operationId;
    @Basic
    @Column(name = "action_target_id")
    private Integer actionTargetId;
    @Basic
    @Column(name = "object_id")
    private Integer objectId;
    @Basic
    @Column(name = "object_context_id")
    private Integer objectContextId;
    @Basic
    @Column(name = "object_user_ids")
    private String objectUserIds;
    @Basic
    @Column(name = "extraction_date_id")
    private Integer extractionDateId;
    @Basic
    @Column(name = "processing_status_id")
    private int processingStatusId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFactUuidHash() {
        return factUuidHash;
    }

    public void setFactUuidHash(int factUuidHash) {
        this.factUuidHash = factUuidHash;
    }

    public long getActionUserId() {
        return actionUserId;
    }

    public void setActionUserId(long actionUserId) {
        this.actionUserId = actionUserId;
    }

    public Integer getReferenceDataStructureId() {
        return referenceDataStructureId;
    }

    public void setReferenceDataStructureId(Integer referenceDataStructureId) {
        this.referenceDataStructureId = referenceDataStructureId;
    }

    public int getEventDateId() {
        return eventDateId;
    }

    public void setEventDateId(int eventDateId) {
        this.eventDateId = eventDateId;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getActionTargetId() {
        return actionTargetId;
    }

    public void setActionTargetId(Integer actionTargetId) {
        this.actionTargetId = actionTargetId;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Integer getObjectContextId() {
        return objectContextId;
    }

    public void setObjectContextId(Integer objectContextId) {
        this.objectContextId = objectContextId;
    }

    public String getObjectUserIds() {
        return objectUserIds;
    }

    public void setObjectUserIds(String objectUserIds) {
        this.objectUserIds = objectUserIds;
    }

    public Integer getExtractionDateId() {
        return extractionDateId;
    }

    public void setExtractionDateId(Integer extractionDateId) {
        this.extractionDateId = extractionDateId;
    }

    public int getProcessingStatusId() {
        return processingStatusId;
    }

    public void setProcessingStatusId(int processingStatusId) {
        this.processingStatusId = processingStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactsEntity that = (FactsEntity) o;
        return id == that.id && factUuidHash == that.factUuidHash && actionUserId == that.actionUserId && eventDateId == that.eventDateId && processingStatusId == that.processingStatusId && Objects.equals(referenceDataStructureId, that.referenceDataStructureId) && Objects.equals(operationId, that.operationId) && Objects.equals(actionTargetId, that.actionTargetId) && Objects.equals(objectId, that.objectId) && Objects.equals(objectContextId, that.objectContextId) && Objects.equals(objectUserIds, that.objectUserIds) && Objects.equals(extractionDateId, that.extractionDateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, factUuidHash, actionUserId, referenceDataStructureId, eventDateId, operationId, actionTargetId, objectId, objectContextId, objectUserIds, extractionDateId, processingStatusId);
    }
}
