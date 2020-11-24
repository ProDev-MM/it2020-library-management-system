package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.email = ?1")
   public Optional<Student> findByEmail(String email);

//    @Query("select stu from Student stu where stu.rollNo = ?1")
    public List<Student> findByRollNo(String rollNo);
}
