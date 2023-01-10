package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.DimReferenceDataStructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimReferenceDataStructureEntityRepository extends JpaRepository<DimReferenceDataStructureEntity, Integer> {
}

