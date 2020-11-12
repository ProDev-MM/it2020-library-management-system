package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Table(name = "Student")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String rollNo;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
