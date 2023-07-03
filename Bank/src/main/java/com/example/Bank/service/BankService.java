package com.example.Bank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.entity.AccountEntity;
import com.example.Bank.entity.TransactionEntity;
import com.example.Bank.entity.UsersEntity;
import com.example.Bank.repo.AccountRepo;
import com.example.Bank.repo.TransactionRepo;
import com.example.Bank.repo.UsersRepo;

@Service 
public class BankService {
	@Autowired
	UsersRepo usersRepo;
	@Autowired 
	AccountRepo accountrepo;
	@Autowired
	TransactionRepo transactionRepo;
	
	public int findingPresence(String ph) {
	Optional<UsersEntity> use=usersRepo.findByPhonenum(ph);
	if(use.isPresent()) {
		int id=use.get().getUid();
		return id;
	}
	else {
		return 0;
	}
	}
	
	
	public int findPresence(int id) {
		Optional<AccountEntity> use=accountrepo.findById(id);
		if(use.isPresent()) {
			int balance=use.get().getBalance();
			return balance;
		}
		else {
			return -1;
		}
	}
	
	public String updation(int id,String type,int amount,String date) {
		TransactionEntity trans=new TransactionEntity(id,type,amount,date);
		transactionRepo.save(trans);
		return "transaction sucessfull";
	}
	
	public Optional<AccountEntity> findingid(int i){
		Optional<AccountEntity> opt=accountrepo.findById(i);
		return opt;
	}
}
