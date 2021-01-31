package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.pojo.CredentialPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class CredentialController {
    @Autowired
    private CredentialService credentialService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/credentials")
    public BaseResponse getCredential(Pageable pageable) {
        Page<Credential> credential;
        try {
            credential = credentialService.getCredential(pageable);
        } catch (Exception e) {
            System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, credential, GlobalConstant.Message.success_message);
    }

    @GetMapping(value = "/credential/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        Credential credential;
        try {
            credential = credentialService.findById(id);
            out.println(credential);
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, credential, GlobalConstant.Message.success_message);
    }
    @GetMapping(value = "/findByCredentialUserId/{id}")
    public BaseResponse getByUserId(@PathVariable Long id) {
        List<Credential> credential;
        try {
              credential =credentialService.findByCredentialUserId(id);
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, credential, GlobalConstant.Message.success_message);
    }

    @DeleteMapping(value = "/delete/credential/{id}")
    public BaseResponse deleteCredential(@PathVariable Long id) {
        try {
            credentialService.deleteCredential(id);
        } catch (Exception e) {
            out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping(value = "/update/password")
    public BaseResponse updateCredential(@Validated @RequestBody CredentialPojo credentialPojo) {
        Credential credentials;
        try {
            Credential credential = credentialService.findById(credentialPojo.getId());
            Optional<Credential> optionalCredential= credentialService.findOldPassword(credential.getPassword());
            out.println("password" + credential.getPassword());
            out.println(optionalCredential);
            credentialPojo.setOld_password(credential.getPassword());
            if (!optionalCredential.isPresent() ) {
                return null;
            }
            String encriptedPassword = passwordEncoder.encode(credentialPojo.getPassword());
            credential.setPassword(encriptedPassword);
            credentials = credentialService.save(credential);
//            credential.setEmail(credentialPojo.getEmail());
           } catch (Exception e) {
            System.out.println("Error occur " + e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, credentials, GlobalConstant.Message.success_message);

    }



//    @PutMapping(value = "/update/credential")
//    public BaseResponse updateCredential(@Validated @RequestBody CredentialPojo credentialPojo) {
//        Credential credentials;
//        try {
//            Credential credential = credentialService.findById(credentialPojo.getId());
//            out.println("password" + credential.getPassword());
//            if (credential == null) {
//                return null;
//            }
//            credential.setEmail(credentialPojo.getEmail());
//            String encriptedPassword = passwordEncoder.encode(credentialPojo.getPassword());
//            credential.setPassword(encriptedPassword);
//            credential.setRole(credentialPojo.getRole());
//            credentials = credentialService.save(credential);
//
//        } catch (Exception e) {
//            System.out.println("Error occur " + e.getMessage());
//            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
//        }
//
//        return new BaseResponse(GlobalConstant.success, credentials, GlobalConstant.Message.success_message);
//
//    }
}
