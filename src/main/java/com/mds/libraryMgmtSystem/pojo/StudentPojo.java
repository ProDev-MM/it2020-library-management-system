package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.LibraryCard;
import com.mds.libraryMgmtSystem.entity.Student;

import java.time.LocalDate;

public class StudentPojo {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private String password;
    private String role;
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

