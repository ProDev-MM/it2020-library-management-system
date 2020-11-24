package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.entity.Librarian;
import com.mds.libraryMgmtSystem.entity.Student;
import com.mds.libraryMgmtSystem.pojo.UserDetailInfo;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
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

    private CredentialRepository credentialRepository;
//    private StudentRepository studentRepository;

    public CustormUserDetailsService(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
//        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetailInfo userDetailInfo = null;
        Optional<Credential> optionalCredential = credentialRepository.findByEmail(email);
        if(optionalCredential.isPresent()){
            Credential credential = optionalCredential.get();
            userDetailInfo = new UserDetailInfo(credential);
        }
        return userDetailInfo;
    }

}
