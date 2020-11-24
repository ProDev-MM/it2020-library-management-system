package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.UserDetailInfo;
import com.mds.libraryMgmtSystem.repository.LibrarianRepository;
import com.mds.libraryMgmtSystem.repository.StudentRepository;
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
//    private StudentRepository studentRepository;

    public CustormUserDetailsService(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
//        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetailInfo userDetailInfo = null;
        Optional<Librarian> optionalLibrarian = librarianRepository.findByEmail(email);
//        Optional<Student> optionalStudent = studentRepository.findByEmail(email);
        if(optionalLibrarian.isPresent()){
            Librarian librarian = optionalLibrarian.get();
            userDetailInfo = new UserDetailInfo(librarian);
        }
        return userDetailInfo;
    }

}
