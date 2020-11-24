package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CredentialRepository credentialRepository;

    //New controller
    @GetMapping(value = "/librarians")
    public BaseResponse getLibrarian() {
        List<Librarian> librarian;
        try {
            librarian = librarianService.getLibrarian();
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, librarian, GlobalConstant.Message.success_message);
    }

//    @PostMapping("/login")
//    public ResponseEntity<Student> login(Authentication authentication){
//        UserDetailInfo userDetailInfo = (UserDetailInfo) authentication.getPrincipal();
//        Student student = userDetailInfo.getStudent();
//        student.setPassword(null);
//        return ResponseEntity.ok(student);
//    }

    @GetMapping(value = "/librarian/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        Librarian librarian;
        try {
            librarian = librarianService.findById(id);
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, librarian, GlobalConstant.Message.success_message);
    }

    @PostMapping("/create/Librarian")
    public BaseResponse createStudent(@RequestBody LibrarianPojo librarianPojo) {
        Librarian librarians;

        try {
            Optional<Credential> email = credentialRepository.findByEmail(librarianPojo.getEmail());
//            List<Student> stud = bookService.findByRollNo(student.getRollNo());
//            if(email== null || email.isPresent()) {
//                out.println("Already Email Exist");
//                return null;
//            }
            String encriptedPassword = passwordEncoder.encode(librarianPojo.getPassword());
            librarianPojo.setPassword(encriptedPassword);
            librarians = librarianService.addLibrarian(librarianPojo);

        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, librarians, GlobalConstant.Message.success_message);
    }


    @DeleteMapping(value = "/librarian/{id}")
    public BaseResponse deleteLibrarian(@PathVariable Long id) {
        try {
            librarianService.deleteLibrarian(id);
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping(value = "/librarian")
    public BaseResponse updateLibrarian(@RequestBody LibrarianPojo librarianPojo) {
        Librarian librarians;
        try {
            Librarian librarian = librarianService.findById(librarianPojo.getId());
            Librarian librarianId = librarianService.findById(librarian.getId());
            Optional<Credential> email = credentialRepository.findByEmail(librarianPojo.getEmail());

            if (librarian == null || (email.isPresent()) && (librarian != librarianId)) {
                out.println("Email Already Exists");
                return null;
            }
            librarian.setName(librarianPojo.getName());
            librarianPojo.setEmail(librarianPojo.getEmail());
            librarian.setAddress(librarianPojo.getAddress());
            librarian.setPhone(librarianPojo.getPhone());
            librarianPojo.setPassword(librarianPojo.getPassword());
            librarian.setPosition(librarianPojo.getPosition());
            librarians = librarianService.save(librarian);

        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, librarians, GlobalConstant.Message.success_message);

    }

}
