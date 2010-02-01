package com.main.account;

import com.uni.Logging.Log;

public class Account {

	private String id;
	private double balance;
		
	public Account(double balance, String id){
		Log.writeMessage("Creating account : "+id);
		this.balance = balance;
		this.id = id;
	}
	
	public boolean withDraw(double value){
		if(value > this.balance){
			Log.writeMessage("Insufficient Funds");
			return false;
		}else{
			this.balance = this.balance - value;
			Log.writeMessage("Withdraw: " + value + " New Balance: " + this.balance);
			return true;
		}
	}
	
	public void deposit(double value){
		this.balance += value;
		Log.writeMessage("Deposit: " + value + " New Balance: " + this.balance);
	}
	
	public void displayBalance(){
		Log.writeMessage("Balance: " + this.balance);
	}
	
}
