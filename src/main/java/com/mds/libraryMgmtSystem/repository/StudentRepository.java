package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query (value = "Select s from Student s where s.name like concat('%',concat(?1,'%'))")
    List<Student> findByName(String name);

}
