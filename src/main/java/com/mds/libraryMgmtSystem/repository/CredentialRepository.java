package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {

    @Query(value = "select c from Credential c where c.email = ?1")
    Optional<Credential> findByEmail(String email);

    @Query(value = "select cr from Credential cr where cr.user.id = ?1")
    Credential findByUserId(Long id);

    @Query(value = "select cr from Credential cr where cr.user.id = ?1")
    List<Credential> findByCredentialUserId(Long id);

    @Query(value = "select cre from Credential cre where cre.password = ?1")
    Optional<Credential> findOldPassword(String password);
}
