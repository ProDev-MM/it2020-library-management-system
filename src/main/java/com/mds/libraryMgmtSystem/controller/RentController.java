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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class RentController {
    @Autowired
    private RentService rentService;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LibrarianService librarianService;

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
    public BaseResponse createRent(@Validated @RequestBody RentPojo rentPojo){
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

    @PutMapping (value = "/update/rent")
    public BaseResponse updateRent(@Validated @RequestBody RentPojo rentPojo) {

       Rent rents;
        try{
            Optional<Book> book = Optional.ofNullable(bookService.findById(rentPojo.getBookId()));
            if(!book.isPresent()){
                throw new EntityNotFoundException("Book not found");
            }
            Optional<Student> student = Optional.ofNullable(studentService.findById(rentPojo.getStudentId()));
            if(!student.isPresent()){
                throw new EntityNotFoundException("Student not found");
            }
            Optional<Librarian> librarian = Optional.ofNullable(librarianService.findById(rentPojo.getLibrarianId()));
            if(!librarian.isPresent()){
                throw new EntityNotFoundException("Librarian not found");
            }
            Rent rent = rentService.findById(rentPojo.getId());

            if(rent == null){
                return null;
            }
            rent.setRentFromDate(rentPojo.getRentFromDate());
            rent.setRentToDate(rentPojo.getRentToDate());
            rent.setReturnDate(rentPojo.getReturnDate());
            rent.setFine(rentPojo.getFine());
            rent.setBook(book.get());
            rent.setStudent(student.get());
            rent.setLibrarian(librarian.get());
            rents = rentService.updateRent(rent);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, rents,GlobalConstant.Message.success_message);

    }

}
