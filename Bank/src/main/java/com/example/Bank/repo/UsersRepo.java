package com.example.Bank.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Bank.entity.UsersEntity;

public interface UsersRepo extends JpaRepository<UsersEntity,Integer>{

	Optional<UsersEntity> findByPhonenum(String phonenum);
			
//	Optional<UsersEntity> findbyphonenum(String s);
}
