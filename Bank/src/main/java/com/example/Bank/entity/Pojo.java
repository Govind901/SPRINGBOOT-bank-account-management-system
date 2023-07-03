package com.example.Bank.entity;

public class Pojo {
	int sourceid;
	int desstid;
	int amount;
	public int getSourceid() {
		return sourceid;
	}
	public void setSourceid(int sourceid) {
		this.sourceid = sourceid;
	}
	public int getDesstid() {
		return desstid;
	}
	public void setDesstid(int desstid) {
		this.desstid = desstid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pojo(int sourceid, int desstid, int amount) {
		super();
		this.sourceid = sourceid;
		this.desstid = desstid;
		this.amount = amount;
	}
	
}
