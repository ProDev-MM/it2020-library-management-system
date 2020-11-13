package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Book;
import com.mds.libraryMgmtSystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query (value = "Select l from Book l where l.name like concat('%',concat(?1,'%'))"
            + "or l.author like concat('%',concat(?2,'%'))"
            + "or l.edition like concat('%',concat(?3,'%'))")
    List<Book> searchBook(String name, String author, String edition);

    @Query(value="select b.* from book b inner join category c on b.category_id = c.id where c.id = ?1", nativeQuery=true)
    List<Book> findByCategoryId(Long id);

    @Query(value="select b.* from book b inner join shelf s on b.shelf_id = s.id where s.id = ?1", nativeQuery=true)
    List<Book> findByShelfId(Long id);
}
