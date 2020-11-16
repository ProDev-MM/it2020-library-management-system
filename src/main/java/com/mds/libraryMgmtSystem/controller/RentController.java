package com.mds.libraryMgmtSystem.controller;

import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Rent;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.RentPojo;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.BookService;
import com.mds.libraryMgmtSystem.service.LibrarianService;
import com.mds.libraryMgmtSystem.service.RentService;
import com.mds.libraryMgmtSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class RentController {
    @Autowired
    RentService rentService;

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @Autowired
    LibrarianService librarianService;

    @GetMapping(value = "/rents")
    public BaseResponse getRent(){
        List<Rent> rent;
        try{
            rent= rentService.getRent();
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, rent, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/rent/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Rent rent;
        try{
            rent = rentService.findById(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, rent, GlobalConstant.Message.success_message);
    }


    @PostMapping("/create/rent")
    public BaseResponse createRent(@RequestBody RentPojo rentPojo){
        Rent rent;
        try{
            rent = rentService.addRent(rentPojo);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, e.getMessage());
        }

        return new BaseResponse(GlobalConstant.success, rent,GlobalConstant.Message.success_message);
    }

    @DeleteMapping(value="/rent/{id}")
    public BaseResponse deleteRent(@PathVariable Long id){
        try {
            rentService.deleteRent(id);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping (value = "/update/student")
    public BaseResponse updateRent(@RequestBody RentPojo rentPojo) {

       Rent rents;


        try{

            Rent rent = rentService.findById(rentPojo.getId());

            if(rent == null){
                return null;
            }
            rent.setRentFromDate(rentPojo.getRentFromDate());
            rent.setRentToDate(rentPojo.getRentToDate());
            rent.setReturnDate(rentPojo.getReturnDate());
            rent.setFine(rentPojo.getFine());
            rents = rentService.updateRent(rent);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, rents,GlobalConstant.Message.success_message);

    }

}
