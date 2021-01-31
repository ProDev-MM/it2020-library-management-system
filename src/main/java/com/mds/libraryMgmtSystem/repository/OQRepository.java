package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.OQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OQRepository extends JpaRepository<OQ, Long> {
    @Query(value = "Select oq from OQ oq where oq.subject like concat('%',concat(?1,'%'))")
    List<OQ> findBySubject(String subject);
}
