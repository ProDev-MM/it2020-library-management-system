package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Category;
import com.mds.libraryMgmtSystem.entity.Shelf;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class BookPojo {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String author;
    private String edition;
    private String isbn;
    @NotEmpty
    private String imgUrl;
    private String price;

    private Category categories;
    private Shelf shelves;

    public BookPojo(Long id, String name, String author, String edition, String isbn, String imgUrl, String price, Category categories, Shelf shelves) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
        this.imgUrl = imgUrl;
        this.price = price;
        this.categories = categories;
        this.shelves = shelves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Shelf getShelves() {
        return shelves;
    }

    public void setShelves(Shelf shelves) {
        this.shelves = shelves;
    }
}
