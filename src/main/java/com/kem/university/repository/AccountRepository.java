package com.kem.university.repository;

import com.kem.university.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    Optional<AccountEntity> findByUserName(String userName);
}