package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.pojo.LibrarianPojo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import com.mds.libraryMgmtSystem.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LibrarianService {
    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private CredentialService credentialService;

    public Page<Librarian> getLibrarian(Pageable pageable) {
        return librarianRepository.findAll(pageable);
    }

    public Librarian findById(Long id) {
        return librarianRepository.findById(id).orElse(null);
    }

    public Librarian addLibrarian(LibrarianPojo librarianPojo) {

        Librarian librarian = new Librarian();
        librarian.setName(librarianPojo.getName());
        librarian.setAddress(librarianPojo.getAddress());
        librarian.setPhone(librarianPojo.getPhone());
        librarian.setPosition(librarianPojo.getPosition());
        librarianRepository.save(librarian);
        Credential credential = new Credential();
        credential.setEmail(librarianPojo.getEmail());
        credential.setPassword(librarianPojo.getPassword());
        credential.setRole(librarianPojo.getRole());
        credential.setUser(librarian);
        credentialRepository.save(credential);

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

    public List<Librarian> searchLibrarian(String name) {
        return librarianRepository.findByLibrarianName(name);
    }
}

