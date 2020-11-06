package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBook() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Collection<Book> saveAll(Collection<Book> books) {
        return  bookRepository.saveAll(books);
    }

    public List<Book> bookSearch(String name, String author, String edition) {
        return bookRepository.searchBook(name, author, edition);
    }
}
