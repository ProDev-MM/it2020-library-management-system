package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Category")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private Long id;

    @Column
    private String type;

    @Column
    private String description;

    @OneToMany
    @JoinColumn(name = "Category_Id")
    private Collection<Book> books;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", books=" + books +
                '}';
    }

    public void addBook(Book book) {
        if (books==null) {
            books = new ArrayList<Book>();
        }
        if (!books.contains(book)) {
            books.add(book);
        }
    }
}