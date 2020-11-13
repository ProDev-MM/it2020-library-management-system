package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {
}
