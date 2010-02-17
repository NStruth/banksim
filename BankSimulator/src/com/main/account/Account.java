package com.main.account;

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
	
	public int getBalance()
	{
		return this.balance;
	}
	
	public int getId(){
		return id;
	}
	
	//Adds a zero if the balance has a trailing zero
	// e.g. balance 150.2 becomes 150.20
	public String toString(){
		String strBalance = Double.toString(this.balance);
		
		int indexOfDecPlace = strBalance.lastIndexOf(".");
		String afterDecPlace = strBalance.substring(indexOfDecPlace);
		if(afterDecPlace.length() <= 2)
		{
			return this.id + " " + this.balance + "0";
		}
		else
		{
			return this.id + " " + this.balance;
		}
	}
	
}
