package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.repository.CategoryRepository;
import com.mds.libraryMgmtSystem.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

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
}
