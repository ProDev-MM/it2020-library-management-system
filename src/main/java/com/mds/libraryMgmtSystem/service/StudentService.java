package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.pojo.StudentPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
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

    @Autowired
    private CredentialRepository credentialRepository;


    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(StudentPojo studentPojo) {
//        Optional<Librarian> optionalLibrarian = librarianRepository.findByEmail(librarian.getEmail());
//        if(optionalLibrarian.isPresent()){
//            throw new EntityExistsException(" User with " + librarian.getEmail() + " already exist!");
//        }

        // sample
        Student student = new Student();
        student.setName(studentPojo.getName()); // .......
        student.setAddress(studentPojo.getAddress());
        student.setPhone(studentPojo.getPhone());
        student.setDateOfBirth(studentPojo.getDateOfBirth());
        student.setRollNo(studentPojo.getRollNo());
        studentPojo.setLibraryCardId(studentPojo.getLibraryCardId());
//        student.setPosition(studentPojo.getPosition());
        studentRepository.save(student);
        Credential credential = new Credential();
        credential.setEmail(studentPojo.getEmail());// ........
        credential.setPassword(studentPojo.getPassword());
        credential.setRole(studentPojo.getRole());
        credential.setUser(student);
        credentialRepository.save(credential);
        // sample
        return student;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {

        return studentRepository.save(student);
    }

//    public Optional<Credential> findByEmail(String email) {
//        return credentialRepository.findByEmail(email);
//    }


//    public List<Student> findByRollNo(String rollNo) {
//        return studentRepository.findByRollNo(rollNo);
//    }
}
