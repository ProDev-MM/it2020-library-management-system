package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.entity.*;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.pojo.LibraryCardPojo;
import com.mds.libraryMgmtSystem.pojo.UserDetailInfo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import com.mds.libraryMgmtSystem.repository.LibraryCardRepository;
import com.mds.libraryMgmtSystem.repository.StudentRepository;
import com.mds.libraryMgmtSystem.service.CredentialService;
import com.mds.libraryMgmtSystem.service.LibraryCardService;
import com.mds.libraryMgmtSystem.service.StudentService;
import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.pojo.StudentPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;
import static java.lang.System.setOut;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private LibraryCardService libraryCardService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private CredentialService credentialService;
    @Autowired
    private StudentRepository studentRepository;



    @GetMapping(value = "/students")
    public BaseResponse getStudent(Pageable pageable){
        Page<Student> student;
        try{
           student= studentService.getStudent(pageable);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);
    }

    @PostMapping("/student/login")
    public ResponseEntity<Credential> login(Authentication authentication){
        UserDetailInfo userDetailInfo = (UserDetailInfo) authentication.getPrincipal();
        Credential credential = userDetailInfo.getCredential();
//        credential.setEmail(null);
        credential.setPassword(null);
        return ResponseEntity.ok(credential);
    }
//
    @GetMapping(value="/search/student")
    public BaseResponse searchStudent(String name){
        List<Student> student;

        try{
            student = studentService.searchStudent(name);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);
    }


    @GetMapping(value="/student/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Student student;
        try{
            student = studentService.findById(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);
    }


    @DeleteMapping(value="/student/{id}")
    public BaseResponse deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudent(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PostMapping("/create/student")
    public BaseResponse createStudent(@Validated @RequestBody StudentPojo studentPojo) {
        Student students = null;

        try {
            Optional<Credential> email = credentialRepository.findByEmail(studentPojo.getEmail());
            Optional<LibraryCard> optionalLibraryCardRollNo = libraryCardService.findByRollNo(studentPojo.getLibraryCardRollNo());
            if(!optionalLibraryCardRollNo.isPresent()){
                throw new EntityNotFoundException("LibraryCard's RollNo Not Found");
            }
            out.println(optionalLibraryCardRollNo.get().getRollNo());
            if(!email.isPresent() && optionalLibraryCardRollNo.isPresent()){
                String encriptedPassword = passwordEncoder.encode(studentPojo.getPassword());
                studentPojo.setPassword(encriptedPassword);
                students = studentService.addStudent(studentPojo);
            } else{
                if (email.isPresent()){
                    throw new EntityNotFoundException("email already exists");
                }

            }
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, e.getMessage());
        }

        return new BaseResponse(GlobalConstant.success, students, GlobalConstant.Message.success_message);
    }


    @PutMapping (value = "/student/update")
    public BaseResponse updateStudent(@Validated @RequestBody StudentPojo studentPojo) {

        Student students =null;

        try{
            if (this.studentRepository.existsById(studentPojo.getId())) {
                Student student = studentService.findById(studentPojo.getId());
                Optional<LibraryCard> libraryCard = libraryCardService.findByRollNo(studentPojo.getLibraryCardRollNo());
                if (!libraryCard.isPresent()) {
                    throw new EntityNotFoundException("LibraryCardId Not Found");
                }
                Optional<LibraryCard> optionalLibraryCard = libraryCardService.findByRollNo(studentPojo.getLibraryCardRollNo());
                Optional<Credential> optionalCredential = credentialRepository.findByEmail(studentPojo.getEmail());
                Credential credential = credentialService.findByUserId(studentPojo.getId());
                out.println(credential.getUser().getId());
                out.println(studentPojo.getId());
                if (optionalCredential.isPresent() && credential.getUser().getId() == studentPojo.getId()) {
                    student.setName(studentPojo.getName());
                    student.setAddress(studentPojo.getAddress());
                    student.setPhone(studentPojo.getPhone());
                    student.setDateOfBirth(studentPojo.getDateOfBirth());
                    student.setLibraryCard(libraryCard.get());
                    students = studentService.save(student);
                    //credential.setEmail(studentPojo.getEmail());
                    String encryptPassword = passwordEncoder.encode(studentPojo.getPassword());
                    credential.setPassword(encryptPassword);
                    credentialService.save(credential);

                } else if (!optionalCredential.isPresent()) {
                    student.setName(studentPojo.getName());
                    student.setAddress(studentPojo.getAddress());
                    student.setPhone(studentPojo.getPhone());
                    student.setDateOfBirth(studentPojo.getDateOfBirth());
                    student.setLibraryCard(libraryCard.get());
                   students  = studentService.save(student);
                    credential.setEmail(studentPojo.getEmail());
                    String encryptPassword = passwordEncoder.encode(studentPojo.getPassword());
                    credential.setPassword(encryptPassword);
                    credentialService.save(credential);
                }else{
                    throw new EntityExistsException("Email already exists");
                }
            }else {
                throw new EntityNotFoundException(studentPojo.getId() + "must be same");
            }

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, e.getMessage());
        }

        return new BaseResponse(GlobalConstant.success, students,GlobalConstant.Message.success_message);

    }

}
