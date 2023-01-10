package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.DimProductGroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimProductGroupEntityRepository extends JpaRepository<DimProductGroupsEntity, Integer> {
}

