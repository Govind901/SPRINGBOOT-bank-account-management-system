package com.example.Bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="transactions")
@Entity(name="TransactionEntity")
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int tid;
	int aid;
	String transtype;
	int amount;
	String date;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTranstype() {
		return transtype;
	}
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TransactionEntity(int aid, String transtype, int amount, String date) {
		super();
		this.aid = aid;
		this.transtype = transtype;
		this.amount = amount;
		this.date = date;
	}
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
