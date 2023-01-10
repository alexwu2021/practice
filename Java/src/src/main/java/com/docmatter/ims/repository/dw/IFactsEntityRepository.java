package com.docmatter.ims.repository.dw;


import com.docmatter.ims.db.jpa.FactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactsEntityRepository extends JpaRepository<FactsEntity, Integer> {
}

