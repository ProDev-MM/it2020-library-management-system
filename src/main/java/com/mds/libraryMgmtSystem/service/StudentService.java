package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

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
        Optional<Student> optionalStudent = studentRepository.findByEmail(student.getEmail());
        if(optionalStudent.isPresent()){
            throw new EntityExistsException(" User with " + student.getEmail() + " already exist!");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {

        return studentRepository.save(student);
    }

    public Optional<Student> findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


    public List<Student> findByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }
}
