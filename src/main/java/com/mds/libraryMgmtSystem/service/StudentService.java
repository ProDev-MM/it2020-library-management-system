package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.LibraryCard;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.pojo.StudentPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import com.mds.libraryMgmtSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LibraryCardService libraryCardService;

    @Autowired
    private CredentialRepository credentialRepository;


    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(StudentPojo studentPojo) {
        Optional<LibraryCard> libraryCard = Optional.ofNullable(libraryCardService.findById(studentPojo.getLibraryCardId()));
        if(!libraryCard.isPresent()){
            throw new EntityNotFoundException("LibraryCardId Not Found");
        }
        Student student = new Student();
        student.setName(studentPojo.getName());
        student.setAddress(studentPojo.getAddress());
        student.setPhone(studentPojo.getPhone());
        student.setDateOfBirth(studentPojo.getDateOfBirth());
        student.setRollNo(studentPojo.getRollNo());
        student.setLibraryCard(libraryCard.get());
        studentRepository.save(student);
        Credential credential = new Credential();
        credential.setEmail(studentPojo.getEmail());
        credential.setPassword(studentPojo.getPassword());
        credential.setRole(studentPojo.getRole());
        credential.setUser(student);
        credentialRepository.save(credential);
        return student;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> findByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo);
    }
}
