package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.pojo.UserDetailInfo;
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

    @PostMapping("/librarian/login")
    public ResponseEntity<Credential> login(Authentication authentication){
        UserDetailInfo userDetailInfo = (UserDetailInfo) authentication.getPrincipal();
        Credential credential = userDetailInfo.getCredential();
        credential.setPassword(null);
        return ResponseEntity.ok(credential);
    }

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
        Librarian librarians = null;

        try {
            Optional<Credential> email = credentialRepository.findByEmail(librarianPojo.getEmail());
            if(!email.isPresent()) {
                String encriptedPassword = passwordEncoder.encode(librarianPojo.getPassword());
                librarianPojo.setPassword(encriptedPassword);
                librarians = librarianService.addLibrarian(librarianPojo);
            }else {
                out.println("Exists");
            }
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

    @PutMapping(value = "/update/librarian")
    public BaseResponse updateLibrarian(@RequestBody LibrarianPojo librarianPojo) {
        Librarian librarians = null;
        try {
            Librarian librarian = librarianService.findById(librarianPojo.getId());
            Credential credential = credentialService.findById(librarianPojo.getId());
            Optional<Librarian> optionalLibrarian = librarianService.getById(librarianPojo.getId());
            Optional<Credential> email = credentialRepository.findByEmail(librarianPojo.getEmail());
            out.println(librarian);
            out.println(credential);
            if (!email.isPresent() || optionalLibrarian.isPresent()){
                librarian.setName(librarianPojo.getName());
                librarian.setAddress(librarianPojo.getAddress());
                librarian.setPhone(librarianPojo.getPhone());
                librarian.setPosition(librarianPojo.getPosition());
                librarians = librarianService.save(librarian);
                credential.setEmail(librarianPojo.getEmail());
                String encryptPassword = passwordEncoder.encode(librarianPojo.getPassword());
                credential.setPassword(encryptPassword);
                credentialService.save(credential);
            }else {
                out.println("!Email already");

            }


        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success , librarians, GlobalConstant.Message.success_message);
    }

}
