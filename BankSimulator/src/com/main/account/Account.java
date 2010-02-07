package com.main.account;

import com.uni.Logging.Log;

public class Account {

	public static int masterNumber = 60000;
	private int id;
	private double balance;
		
	public Account(double balance, int id){
		Log.writeMessage("Creating account : "+id);
		this.balance = balance;
		this.id = id;
		masterNumber++;
	}
	public Account()
	{
		this.balance = 100.00;
		masterNumber++;
		this.id = masterNumber;
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
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public int getId(){
		return id;
	}
	
	public String toString(){
		return id + " " + balance;
	}
	
}
