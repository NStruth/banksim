package com.main.account;

import com.uni.Logging.Log;

public class Account {

	double balance;
		
	public Account(double balance){
		Log.writeMessage("Creating account");
		this.balance = balance;
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
