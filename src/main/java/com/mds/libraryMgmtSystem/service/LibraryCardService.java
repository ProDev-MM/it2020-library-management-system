package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.LibraryCard;
import com.mds.libraryMgmtSystem.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryCardService {
    @Autowired
    LibraryCardRepository libraryCardRepository;

    public List<LibraryCard> getLibraryCard() {
        return libraryCardRepository.findAll();
    }

    public LibraryCard findById(Long id) {
        return libraryCardRepository.findById(id).orElse(null);
    }

    public LibraryCard addLibraryCard(LibraryCard libraryCard) {
        return libraryCardRepository.save(libraryCard);
    }

    public void deleteLibraryCard(Long id) {
        libraryCardRepository.deleteById(id);
    }

    public LibraryCard updateLibraryCard(LibraryCard libraryCard) {
        return libraryCardRepository.save(libraryCard);
    }
}
