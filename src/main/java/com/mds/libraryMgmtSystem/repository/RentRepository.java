package com.mds.libraryMgmtSystem.repository;

import com.mds.libraryMgmtSystem.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
}
