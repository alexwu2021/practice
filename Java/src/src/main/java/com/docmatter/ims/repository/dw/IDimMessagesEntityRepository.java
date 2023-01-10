package com.docmatter.ims.repository.dw;

import com.docmatter.ims.db.jpa.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDimMessagesEntityRepository extends JpaRepository<DimMessagesEntity, Integer> {
}
