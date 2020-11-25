package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.CredentialPojo;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.CredentialService;
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

    @Autowired
    private CredentialService credentialService;

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
    public BaseResponse createLibrarian(@RequestBody LibrarianPojo librarianPojo) {
        Librarian librarians;

        try {
            Optional<Credential> email = credentialRepository.findByEmail(librarianPojo.getEmail());
            if(email== null || email.isPresent()) {
                out.println("Already Email Exist");
                return null;
            }

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
//    @PutMapping(value = "/update/librarian")
//    public BaseResponse updateLibrarian(@RequestBody CredentialPojo credentialPojo) {
//        Credential credentials;
//        try {
//            Credential credential = credentialService.findById(credentialPojo.getId());
//
//            if(credential == null){
//                return  null;
//            }
//            credential.setEmail(credentialPojo.getEmail());
//            credential.setPassword(credentialPojo.getPassword());
//            credential.setRole(credentialPojo.getRole());
//            credential.setUser(credentialPojo.getUser());
//
//           credentials = credentialService.save(credential);
//
//        } catch (Exception e) {
//            out.println("Error occur " + e.getMessage());
//            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
//        }
//
//        return new BaseResponse(GlobalConstant.success,credentials , GlobalConstant.Message.success_message);
//    }

//    @PutMapping(value = "/update/librarian")
//    public BaseResponse updateLibrarian(@RequestBody LibrarianPojo librarianPojo) {
//        Librarian librarians;
//        try {
//            Librarian librarian = librarianService.findById(librarianPojo.getId());
//
////            Librarian librarianId = librarianService.findById(librarian.getId());
////            Optional<Credential> email = credentialRepository.findByEmail(librarianPojo.getEmail());
////
////            if (librarian == null || (email.isPresent()) && (librarian != librarianId)) {
////                out.println("Email Already Exists");
////                return null;
////            }
//            if(librarian == null){
//                return  null;
//            }
//            librarian.setName(librarianPojo.getName());
//            librarian.setAddress(librarianPojo.getAddress());
//            librarian.setPhone(librarianPojo.getPhone());
//            librarian.setPosition(librarianPojo.getPosition());
//            librarians = librarianService.save(librarian);
//            Credential credential = new Credential();
//            credential.setEmail(librarianPojo.getEmail());
//            credential.setPassword(librarianPojo.getPassword());
//            credential.setRole(librarianPojo.getRole());
//            credential.setUser(librarian);
//            credentialService.save(credential);
//
//        } catch (Exception e) {
//            out.println("Error occur " + e.getMessage());
//            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
//        }
//
//        return new BaseResponse(GlobalConstant.success, librarians, GlobalConstant.Message.success_message);
//    }

}
