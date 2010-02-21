package com.uni.account;

import com.uni.Logging.Log;

//Account object for staring the balance of the customers accounts
public class Account {

	public static int masterNumber = 60000;
	private int id;
	private int balance; //in pence
		
	//New accounts are given an unique id starting at 60000
	public Account(int balance, int id){
		Log.writeMessage("Creating account : "+id);
		this.balance = balance;
		this.id = id;
		masterNumber++;
	}
	
	//Constructor used when teller creates an account
	//default customer is given £100 to start
	public Account()
	{
		this.balance = 10000;
		masterNumber++;
		this.id = masterNumber;
	}
	
	
	public boolean withDraw(int value){
		if(value > this.balance){
			return false;
		}else{
			this.balance = this.balance - value;
			return true;
		}
	}
	
	public void deposit(double value){
		this.balance += value;
	}
	
	public void displayBalance(){
		Log.writeMessage("Balance: " + this.balance);
	}
	
	public int getBalance()
	{
		return this.balance;
	}
	
	public int getId(){
		return id;
	}
	

	
}
