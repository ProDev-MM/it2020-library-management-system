package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {
    @Query(value = "Select s from Shelf s where s.room like concat('%',concat(?1,'%'))")
    List<Shelf> findByRoom(String room);
}
