package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String author;

    @Column
    private String edition;

    @Column
    private String imgUrl;

    @Column
    private String isbn;

    @Column
    private String price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category categories;

    @ManyToOne
    @JoinColumn(name="shelfId")
    private Shelf shelves;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price='" + price + '\'' +
                ", categories=" + categories +
                ", shelves=" + shelves +
                '}';
    }
}
