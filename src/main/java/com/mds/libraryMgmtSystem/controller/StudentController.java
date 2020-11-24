package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.LibraryCard;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import com.mds.libraryMgmtSystem.service.LibraryCardService;
import com.mds.libraryMgmtSystem.service.StudentService;
import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.pojo.StudentPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

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


    @GetMapping(value = "/students")
    public BaseResponse getStudent(){
        List<Student> student;
        try{
           student= studentService.getStudent();
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, student, GlobalConstant.Message.success_message);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Student> login(Authentication authentication){
//        UserDetailInfo userDetailInfo = (UserDetailInfo) authentication.getPrincipal();
//        Student student = userDetailInfo.getStudent();
//        student.setPassword(null);
//        return ResponseEntity.ok(student);
//    }

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

    @PostMapping("/create/student")
    public BaseResponse createStudent(@RequestBody StudentPojo studentPojo) {
        Student students;

        try {
            Optional<Credential> email = credentialRepository.findByEmail(studentPojo.getEmail());
//            List<Student> stud = bookService.findByRollNo(student.getRollNo());
//            if(email== null || email.isPresent()) {
//                out.println("Already Email Exist");
//                return null;
//            }
            String encriptedPassword = passwordEncoder.encode(studentPojo.getPassword());
            studentPojo.setPassword(encriptedPassword);
            students = studentService.addStudent(studentPojo);

        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, students, GlobalConstant.Message.success_message);
    }


    @PutMapping (value = "/student")
    public BaseResponse updateStudent(@RequestBody StudentPojo studentPojo) {

        Student students;

        try{
            Student student = studentService.findById(studentPojo.getId());
//            Optional<LibraryCard> libraryCard = Optional.ofNullable(libraryCardService.findById(studentPojo.getLibraryCardId()));
//            if(!libraryCard.isPresent()){
//                throw new EntityNotFoundException("LibraryCard ID not found");
//            }

            Student studentId = studentService.findById(student.getId());
            Optional<Credential> email = credentialRepository.findByEmail(studentPojo.getEmail());

//            List<Student> rollNo = studentService.findByRollNo(studentPojo.getRollNo());

            if(student==null  ) {
//|| (email.isPresent())  && (student != studentId)
                return null;
            }
                student.setName(studentPojo.getName());
                studentPojo.setEmail(studentPojo.getEmail());
                student.setAddress(studentPojo.getAddress());
                student.setPhone(studentPojo.getPhone());
                student.setRollNo(studentPojo.getRollNo());
                student.setDateOfBirth(studentPojo.getDateOfBirth());
                studentPojo.setPassword(studentPojo.getPassword());
//                student.setLibraryCard(libraryCard.getId());
                students = studentService.save(student);


        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, e.getMessage());
        }

        return new BaseResponse(GlobalConstant.success, students,GlobalConstant.Message.success_message);

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
}
