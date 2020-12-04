package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "Select cate from Category cate where cate.type like concat('%',concat(?1,'%'))")
    List<Category> findByType(String type);
}
