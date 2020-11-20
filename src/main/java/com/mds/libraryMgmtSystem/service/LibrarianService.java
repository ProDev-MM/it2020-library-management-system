package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    public List<Librarian> getLibrarian() {
        return  librarianRepository.findAll();
    }

    public Librarian findById(Long id) {
        return librarianRepository.findById(id).orElse(null);
    }

    public Librarian addLibrarian(Librarian librarian) {
        Optional<Librarian> optionalLibrarian = librarianRepository.findByEmail(librarian.getEmail());
        if(optionalLibrarian.isPresent()){
            throw new EntityExistsException(" User with " + librarian.getEmail() + " already exist!");
        }
        return librarianRepository.save(librarian);
    }

    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }

    public Librarian save(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public Optional<Librarian> findByEmail(String email) {
        return librarianRepository.findByEmail(email);
    }
}
