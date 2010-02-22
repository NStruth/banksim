/**
 * @author Jon Mirhadi
 * @author Neil Struth
 * 
 * @version 1.0
 * 
 * A class to manage accounts.  
 * Each account has a unique identifier and a balance.
 * Users can withdraw and deposit money. Overdrafts
 * are not allowed.
 */
package com.uni.account;

import com.uni.Logging.Log;
import com.uni.main.Statistics;

public class Account {

	//the master account number
	public static int masterNumber = 60000;
	
	private int accountNumber; //individual identifier
	private int balance; //in pence
		
	//New accounts are given an unique id starting at 60000
	public Account(int balance, int id){
		Log.writeMessage("Creating account : "+id);
		this.balance = balance;
		this.accountNumber = id;
		masterNumber++;
	}
	
	//Constructor used when teller creates an account
	//default customer is given £100 to start
	public Account()
	{
		this.balance = 10000;
		masterNumber++;
		this.accountNumber = masterNumber;
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
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public String toString()
	{
		return this.accountNumber + " : " + Statistics.toPoundsAndPence(getBalance());
	}
	

	
}
