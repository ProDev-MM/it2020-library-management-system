package com.mds.libraryMgmtSystem.controller;


import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.response.BaseResponse;
import com.mds.libraryMgmtSystem.service.BookService;
import com.mds.libraryMgmtSystem.constant.GlobalConstant;
import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.pojo.BookPojo;
import com.mds.libraryMgmtSystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/books")
    public BaseResponse getBook(){
        List<Book> book;
        try{
            book= bookService.getBook();
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, book, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/book/{id}")
    public BaseResponse getById(@PathVariable Long id){
        Book book;
        try{
            book = bookService.findById(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, book, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/findByCategory/{id}")
    public BaseResponse getByCategoryId(@PathVariable Long id){
        List<Book> book;
        try{
            book =bookService.findByCategoryId(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, book, GlobalConstant.Message.success_message);
    }

    @GetMapping(value="/findByShelf/{id}")
    public BaseResponse getByShelfId(@PathVariable Long id){
        List<Book> book;
        try{
            book =bookService.findByShelfId(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, book, GlobalConstant.Message.success_message);
    }

    @PostMapping(value = "/book")
    public BaseResponse createBook(@RequestBody Book book){
        try {
            book = bookService.addBook(book);
        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, book, GlobalConstant.Message.success_message);

    }

    @DeleteMapping(value="/book/{id}")
    public BaseResponse deleteBook(@PathVariable Long id){
        try {
            bookService.deleteBook(id);
        }catch(Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }
        return new BaseResponse(GlobalConstant.success, null, GlobalConstant.Message.success_message);

    }

    @PutMapping (value = "/book")
    public BaseResponse updateBook(@RequestBody BookPojo bookPojo) {
        Book books;

        try{
            Book book = bookService.findById(bookPojo.getId());

            if(book==null) {
                return null;
            }
            book.setName(bookPojo.getName());
            book.setAuthor(bookPojo.getAuthor());
            book.setEdition(bookPojo.getEdition());
            book.setImgUrl(bookPojo.getImgUrl());
            book.setIsbn(bookPojo.getIsbn());
            book.setPrice(bookPojo.getPrice());
            books = bookService.save(book);

        }catch(Exception e) {
            out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.fail, null, GlobalConstant.Message.fail_message);
        }

        return new BaseResponse(GlobalConstant.success, books,GlobalConstant.Message.success_message);

    }

    @GetMapping(value="/book/search")
    public List<Book> searchBook(String name,String author,String edition){
        return bookService.bookSearch(name,author,edition);
    }
}
