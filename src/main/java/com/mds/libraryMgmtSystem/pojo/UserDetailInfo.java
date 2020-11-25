package com.mds.libraryMgmtSystem.pojo;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserDetailInfo implements UserDetails {

    @Getter
    private Credential credential;

    public UserDetailInfo(Credential credential) {
        this.credential = credential;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(this.credential.getRole()));
    }

    @Override
    public String getPassword() {
        return this.credential.getPassword();
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @Override
    public String getUsername() {
        return this.credential.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
