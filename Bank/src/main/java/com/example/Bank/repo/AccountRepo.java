package com.example.Bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bank.entity.AccountEntity;
import com.example.Bank.entity.UsersEntity;

public interface AccountRepo extends JpaRepository<AccountEntity, Integer>{

//	Optional<AccountEntity> findByAid(int id);

//	Optional<AccountEntity> findByAid(int aid);
}
