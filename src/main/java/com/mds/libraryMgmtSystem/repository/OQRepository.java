package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.OQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OQRepository extends JpaRepository<OQ, Long> {
}
