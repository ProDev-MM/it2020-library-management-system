package com.mds.libraryMgmtSystem.pojo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StudentPojo {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String address;
    @NotEmpty
    private String phone;
    @NotNull
    private LocalDate dateOfBirth;
    @NotEmpty
    private String password;
    @NotEmpty
    private String role;
    @NotEmpty
    private String libraryCardRollNo;

    public StudentPojo() {

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getLibraryCardRollNo() {
        return libraryCardRollNo;
    }

    public void setLibraryCardRollNo(String libraryCardRollNo) {
        this.libraryCardRollNo = libraryCardRollNo;
    }

}

