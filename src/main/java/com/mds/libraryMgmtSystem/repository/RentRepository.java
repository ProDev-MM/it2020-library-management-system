package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    @Query(value = "Select r from Rent r where r.student.name like concat('%',concat(?1,'%'))")
    List<Rent> findByStudentName(String name);
}
