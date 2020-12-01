package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {

    @Query(value = "select c from Credential c where c.email = ?1")
    Optional<Credential> findByEmail(String email);

    @Query(value = "select cr from Credential cr where cr.user.id = ?1")
    Credential findByUserId(Long id);

}
