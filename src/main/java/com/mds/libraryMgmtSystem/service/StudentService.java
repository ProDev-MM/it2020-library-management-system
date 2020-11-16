package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


    public List<Student> findByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }
}
