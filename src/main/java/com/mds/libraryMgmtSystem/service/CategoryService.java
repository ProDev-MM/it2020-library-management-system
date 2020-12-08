package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.repository.BookRepository;
import com.mds.libraryMgmtSystem.repository.CategoryRepository;
import com.mds.libraryMgmtSystem.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;



    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Collection<Category> saveAll(Collection<Category> categories) {
        return categoryRepository.saveAll(categories);
    }

    public List<Category> searchCategory(String type) {
        return categoryRepository.findByType(type);
    }


    public List<Category> getCategory(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        Page<Category> pagedResult = categoryRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Category>();
        }
    }
}

