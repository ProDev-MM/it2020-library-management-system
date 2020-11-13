package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
}
