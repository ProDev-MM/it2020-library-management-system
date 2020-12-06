package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Shelf;
import com.mds.libraryMgmtSystem.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShelfService {
    @Autowired
    private ShelfRepository shelfRepository;

    public Page<Shelf> getShelves(Pageable pageable) {
        return shelfRepository.findAll(pageable);
    }

    public Shelf findById(Long id) {
        return  shelfRepository.findById(id).orElse(null);
    }

    public Shelf addShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    public void deleteShelf(Long id) {
        shelfRepository.deleteById(id);
    }

    public Shelf updateShelf(Shelf shelf) {
        return shelfRepository.save(shelf);
    }
}
