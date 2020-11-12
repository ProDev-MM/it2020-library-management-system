package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.email = ?1")
   public List<Student> findByEmail(String email);

//    @Query("select stu from Student stu where stu.rollNo = ?2")
    public List<Student> findByRollNo(String rollNo);
}
