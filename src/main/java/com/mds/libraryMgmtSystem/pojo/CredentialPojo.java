package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.User;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public class CredentialPojo {
    private long id;
//    @NotEmpty
//    private String email;
    @NotEmpty
    private String password;

    @NotEmpty
    private String old_password;
//    @NotEmpty
//    private String role;

    public CredentialPojo(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
