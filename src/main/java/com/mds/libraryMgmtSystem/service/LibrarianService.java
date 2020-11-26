package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
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

    @Autowired
    private CredentialRepository credentialRepository;

    public List<Librarian> getLibrarian() {
        return  librarianRepository.findAll();
    }

    public Librarian findById(Long id) {
        return librarianRepository.findById(id).orElse(null);
    }

    public Librarian addLibrarian(LibrarianPojo librarianPojo) {
//
        Librarian librarian = new Librarian();
        librarian.setName(librarianPojo.getName()); // .......
        librarian.setAddress(librarianPojo.getAddress());
        librarian.setPhone(librarianPojo.getPhone());
        librarian.setPosition(librarianPojo.getPosition());
        librarianRepository.save(librarian);
        Credential credential = new Credential();
        credential.setEmail(librarianPojo.getEmail());// ........
        credential.setPassword(librarianPojo.getPassword());
        credential.setRole(librarianPojo.getRole());
        credential.setUser(librarian);
        credentialRepository.save(credential);
        // sample
        return librarian;
    }

    public void deleteLibrarian(Long id) {
        librarianRepository.deleteById(id);
    }

    public Librarian save(Librarian librarian) {
        return librarianRepository.save(librarian);
    }

    public Optional<Librarian> getById(Long id) {
        return librarianRepository.findById(id);
    }
//
//    public Optional<Credential> findByEmail(String email) {
//        return credentialRepository.findByEmail(email);
//    }
}
