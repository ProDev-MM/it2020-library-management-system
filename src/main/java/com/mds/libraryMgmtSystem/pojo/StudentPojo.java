package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.LibraryCard;

import java.time.LocalDate;

public class StudentPojo {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String rollNo;
    private LocalDate dateOfBirth;
    private String password;
    private String role;
    private String libraryCardRollNo;

    public StudentPojo(Long id, String name, String email, String address, String phone, String rollNo, LocalDate dateOfBirth,
                       String password, String role, String libraryCardRollNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.rollNo = rollNo;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
        this.role = role;
        this.libraryCardRollNo = libraryCardRollNo;
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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
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

