package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.DimUsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimUserEntityRepository extends JpaRepository<DimUsersEntity, Integer> {
}

