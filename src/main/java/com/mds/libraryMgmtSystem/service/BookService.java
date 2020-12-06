package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Page<Book> getBook(Pageable pageable) {
       return bookRepository.findAll(pageable);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> bookSearch(String name, String author, String edition) {
        return bookRepository.searchBook(name, author, edition);
    }

    public Book addBook(Book book) {
        return  bookRepository.save(book);
    }

    public List<Book> findByCategoryId(Long id) {
        return bookRepository.findByCategoryId(id);
    }

    public List<Book> findByShelfId(Long id) {
        return bookRepository.findByShelfId(id);
    }


}
