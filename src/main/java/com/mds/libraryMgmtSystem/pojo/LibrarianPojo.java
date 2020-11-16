package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Librarian;

public class LibrarianPojo {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String password;
    private Librarian.Position position;

    public LibrarianPojo(Long id, String name, String email, String address, String phone, String password, Librarian.Position position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.position = position;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Librarian.Position getPosition() {
        return position;
    }

    public void setPosition(Librarian.Position position) {
        this.position = position;
    }
}
