package com.mds.libraryMgmtSystem.pojo;

public class BookPojo {
    Long id;
    String name;
    String author;
    String edition;
    String isbn;
    String imgUrl;
    Double price;


    public BookPojo(Long id, String name, String author, String edition, String isbn, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.isbn = isbn;
        this.imgUrl = imgUrl;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
