package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.User;

public class CredentialPojo {
    private long id;
    private String email;
    private String password;
    private String role;

    private User user;

    public CredentialPojo(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
