package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.DimDiscussionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimUserDiscussionsRepository extends JpaRepository<DimDiscussionsEntity, Integer> {
}

