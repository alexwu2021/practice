package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.DimMessageContextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimMessageContextEntityRepository extends JpaRepository<DimMessageContextEntity, Integer> {
}

