package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.pojo.UserDetailInfo;
import com.mds.libraryMgmtSystem.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("MyUserDetails")
public class CustormUserDetailsService implements UserDetailsService {

    private LibrarianRepository librarianRepository;

    public CustormUserDetailsService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetailInfo userDetailInfo = null;
        Optional<Librarian> optionalLibrarian = librarianRepository.findByEmail(email);
        if(optionalLibrarian.isPresent()){
            Librarian librarian = optionalLibrarian.get();
            userDetailInfo = new UserDetailInfo(librarian.getName(),librarian.getPassword(), librarian.getRole());
        }
        return userDetailInfo;
    }
}
