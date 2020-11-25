package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {
    @Query("select l from LibraryCard l where l.rollNo = ?1")
    Optional<LibraryCard> findByRollNo(String rollNo);

}
