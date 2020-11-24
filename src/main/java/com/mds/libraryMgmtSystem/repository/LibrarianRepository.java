package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
//    @Query("select l from Librarian l where l.email = ?1")
//    Optional<Librarian> findByEmail(String email);
}
