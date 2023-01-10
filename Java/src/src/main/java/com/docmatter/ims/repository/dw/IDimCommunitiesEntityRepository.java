package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.DimCommunitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimCommunitiesEntityRepository extends JpaRepository<DimCommunitiesEntity, Integer> {
}

