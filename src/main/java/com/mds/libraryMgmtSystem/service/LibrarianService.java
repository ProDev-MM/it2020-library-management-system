package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {
    @Autowired
    LibrarianRepository librarianRepository;

    public List<Librarian> getLibrarian() {
        return  librarianRepository.findAll();
    }

    public Librarian findById(Long id) {
        return librarianRepository.findById(id).orElse(null);
    }

    public Librarian addLibrarian(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }

    public Librarian save(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public List<Librarian> findByEmail(String email) {
        return librarianRepository.findByEmail(email);
    }
}
