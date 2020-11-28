package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Librarian;

import javax.validation.constraints.NotEmpty;

public class LibrarianPojo {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String password;
    @NotEmpty
    private String role;
    private Librarian.Position position;

    public LibrarianPojo() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Librarian.Position getPosition() {
        return position;
    }

    public void setPosition(Librarian.Position position) {
        this.position = position;
    }
}
