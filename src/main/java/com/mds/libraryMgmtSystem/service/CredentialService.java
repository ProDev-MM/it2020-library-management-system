package com.mds.libraryMgmtSystem.service;

import com.mds.libraryMgmtSystem.entity.Credential;
import com.mds.libraryMgmtSystem.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    @Autowired
    private CredentialRepository credentialRepository;

    public List<Credential> getCredential() {
        return credentialRepository.findAll();
    }
    public void deleteCredential(Long id) {
        credentialRepository.deleteById(id);
    }

    public Credential findById(long id) {
        return credentialRepository.findById(id).orElse(null);
    }

    public Credential save(Credential credential) {
        return credentialRepository.save(credential);
    }


}
