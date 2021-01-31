package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Rent;
import com.mds.libraryMgmtSystem.entity.Shelf;
import com.mds.libraryMgmtSystem.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ShelfService {
    @Autowired
    private ShelfRepository shelfRepository;

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

    public List<Shelf> getShelves(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<Shelf> pagedResult = shelfRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Shelf>();
        }
    }

    public List<Shelf> searchShelf(String room) {
        return shelfRepository.findByRoom(room);
    }
}
