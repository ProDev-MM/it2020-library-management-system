package com.mds.libraryMgmtSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "librarian")
@SequenceGenerator(name = "seq", initialValue = 1, allocationSize = 100)
public class Librarian implements User{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String password;

    @Column
    private String role;

    @Enumerated(EnumType.STRING)
    private Position position;

    public enum Position{
       Teacher, Clerk;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
