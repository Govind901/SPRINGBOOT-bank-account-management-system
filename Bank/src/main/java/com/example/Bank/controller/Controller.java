package com.example.Bank.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.entity.AccountEntity;
import com.example.Bank.entity.Pojo;
import com.example.Bank.entity.TransactionEntity;
import com.example.Bank.entity.UsersEntity;
import com.example.Bank.repo.AccountRepo;
import com.example.Bank.repo.TransactionRepo;
import com.example.Bank.repo.UsersRepo;
import com.example.Bank.service.BankService;

@RestController
public class Controller {
	String debit="debit";
	String credit="credit";
	LocalDate date1 = LocalDate.now(); 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	String date = date1.format(formatter);
	@Autowired
	UsersRepo usersRepo;
	@Autowired
	BankService bankService;
	@Autowired 
	AccountRepo accountrepo;
	@Autowired
	TransactionRepo transactionRepo;
	
	@PostMapping("/accountCreation")
	public ResponseEntity<UsersEntity> accountCreation(@RequestBody UsersEntity ue) {
		usersRepo.save(ue);
		Optional<UsersEntity> use=usersRepo.findByPhonenum(ue.getPhonenum());
		if(use.isPresent()) {
			int id=use.get().getUid();
			Random rm=new Random();
			int rm1=rm.nextInt(50);
			int rm2=(rm1*100000)+21547854;
			int bal=0;
			AccountEntity acc=new AccountEntity(id,rm2,bal);
			accountrepo.save(acc);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
		}
		
	
	
	
	@GetMapping("/accountbal")
	public String accountBal(@RequestBody AccountEntity ae) {
		int  b=bankService.findPresence(ae.getAid());
		String str=Integer.toString(b);
		if(b!=-1) {
			return str;
		}
		else {
			return "enter correct id";
		}
	}
	
	
	
	@PostMapping("/depositbalance")
	public String depositAmount(@RequestBody TransactionEntity ye) {
		Optional<AccountEntity> use=accountrepo.findById(ye.getAid());
		if(use.isPresent()) {
			int balance=use.get().getBalance()+ye.getAmount();
			use.get().setBalance(balance);
			String str=bankService.updation(ye.getAid(),credit,ye.getAmount(),date);
			return str;
		}
		else {
			return "account id incorrect";
		}
	}
	 
	
	@PostMapping("/withdrawamount")
	public String withdrawAmount(@RequestBody TransactionEntity ye) {
		
		Optional<AccountEntity> use=accountrepo.findById(ye.getAid());
		if(use.isPresent()) {
			if(use.get().getBalance()<ye.getAmount()) {
				return "amount not sufficient";
			}
			else if(use.get().getBalance()==ye.getAmount()) {
				use.get().setBalance(0);
				String str=bankService.updation(ye.getAid(),debit,ye.getAmount(),date);
				return str;
				
			}
			else {
				use.get().setBalance(use.get().getBalance()-ye.getAmount());
				String str=bankService.updation(ye.getAid(),debit,ye.getAmount(),date);
				return str;
			}
		}
		else {
			return "enter correct id";
		}
	}
	
	@GetMapping("/transactionHistory")
	public List<TransactionEntity> getingTransHistory(@RequestBody TransactionEntity te){
		List<TransactionEntity> list= transactionRepo.findAllByaid(te.getAid());
		return list;
	}
	
	@PostMapping("/transferFunds")
	public String transferFunds(@RequestBody Pojo pj) {
		Optional<AccountEntity> use=bankService.findingid(pj.getSourceid());
		Optional<AccountEntity> use1=bankService.findingid(pj.getDesstid());
		if(use.isPresent() && use1.isPresent()) {
			if(use.get().getBalance()<pj.getAmount()) {
				return "amount is less";
			}
			else if(use.get().getBalance()==pj.getAmount()){
				use.get().setBalance(0);
				use1.get().setBalance(use1.get().getBalance()+pj.getAmount());
				bankService.updation(pj.getSourceid(),debit,pj.getAmount(),date);
				bankService.updation(pj.getDesstid(),credit,pj.getAmount(),date);
				return "transfered sucessfully";
			}else {
				use.get().setBalance(use.get().getBalance()-pj.getAmount());
				use1.get().setBalance(use1.get().getBalance()+pj.getAmount());
				bankService.updation(pj.getSourceid(),debit,pj.getAmount(),date);
				bankService.updation(pj.getDesstid(),credit,pj.getAmount(),date);
				return "transfered sucessfully";
			}
		}
		else {
			return "enter correct credentials";
			
		}
		
	}
}
