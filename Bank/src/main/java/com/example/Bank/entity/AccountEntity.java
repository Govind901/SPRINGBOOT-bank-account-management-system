package com.example.Bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Table(name="Accounttable")
@Entity(name="AccountEntity")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int aid;
	int uid;
	int accno;
	int balance;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public AccountEntity(int uid, int accno, int balance) {
		super();
		this.uid = uid;
		this.accno = accno;
		this.balance = balance;
	}
	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
