package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Rent;
import com.mds.libraryMgmtSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query (value = "Select s from Student s where s.name like concat('%',concat(?1,'%'))")
    List<Student> findByName(String name);

    @Query (value="select s from Student s where s.name= ?1")
    Optional<Student> findByStudentName(String studentName);

}
