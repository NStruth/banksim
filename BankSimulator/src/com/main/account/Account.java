package com.main.account;

public class Account {

	double balance;
		
	public Account(double balance){
		this.balance = balance;
	}
	
	public boolean withDraw(double value){
		if(value > this.balance){
			return false;
		}else{
			this.balance =- value;
			return true;
		}
	}
	
	public void deposit(double value){
		this.balance += value;
	}
	
}
