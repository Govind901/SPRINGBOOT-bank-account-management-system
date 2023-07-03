package com.example.Bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Bank.entity.TransactionEntity;

public interface TransactionRepo extends JpaRepository<TransactionEntity, Integer>{

	List<TransactionEntity> findAllByaid(int i);

	
	
}
