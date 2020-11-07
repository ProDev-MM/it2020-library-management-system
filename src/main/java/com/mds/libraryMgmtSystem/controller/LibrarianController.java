package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    //New controller
    @GetMapping(value = "/librarians")
    public BaseResponse getLibrarian(){
        List<Librarian> librarian;
        try{
            librarian= librarianService.getLibrarian();
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, librarian, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/librarian/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Librarian librarian;
        try{
            librarian = librarianService.findById(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, librarian, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/librarian")
    public BaseResponse createLibrarian(@RequestBody Librarian librarian){
        try {
            librarian = librarianService.addLibrarian(librarian);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, librarian, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value="/librarian/{id}")
    public BaseResponse deleteLibrarian(@PathVariable Long id){
        try {
            librarianService.deleteLibrarian(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping (value = "/librarian")
    public BaseResponse updateLibrarian(@RequestBody LibrarianPojo librarianPojo) {
        Librarian librarians;

        try{
            Librarian librarian = librarianService.findById(librarianPojo.getId());

            if(librarian==null) {
                return null;
            }
            librarian.setName(librarianPojo.getName());
            librarian.setEmail(librarianPojo.getEmail());
            librarian.setAddress(librarianPojo.getAddress());
            librarian.setPhone(librarianPojo.getPhone());
            librarian.setPassword(librarianPojo.getPassword());
            librarians = librarianService.save(librarian);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, librarians,GlobalConstant.Message.success_message);

    }



}
