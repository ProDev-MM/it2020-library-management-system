package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.service.StudentService;
import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.pojo.StudentPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    
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

    @PostMapping(value = "/student")
    public BaseResponse createStudent(@RequestBody Student student){
        try {
            student = studentService.addStudent(student);
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

    @PutMapping (value = "/student")
    public BaseResponse updateStudent(@RequestBody StudentPojo studentPojo) {

//        System.out.println(studentPojo.getName());
//        System.out.println(studentPojo.getEmail());

        Student students;

        try{
            Student student = studentService.findById(studentPojo.getId());

        if(student==null) {
            return null;
        }
        student.setName(studentPojo.getName());
        student.setEmail(studentPojo.getEmail());
        student.setAddress(studentPojo.getAddress());
        student.setPhone(studentPojo.getPhone());
        student.setRollNo(studentPojo.getRollNo());
        student.setDateOfBirth(studentPojo.getDateOfBirth());
        student.setPassword(studentPojo.getPassword());
        students = studentService.save(student);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, students,GlobalConstant.Message.success_message);

    }

}
