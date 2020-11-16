package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
