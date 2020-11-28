package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.User;

import javax.validation.constraints.NotEmpty;

public class CredentialPojo {
    private long id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String role;

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


}
