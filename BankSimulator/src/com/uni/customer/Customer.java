package com.uni.customer;

import java.util.ArrayList;

import com.main.account.Account;

public class Customer {

	String fName, lName;
	String address;
	ArrayList<Account> accList;
		
	public Customer(String fName, String lName, String address){
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.accList = new ArrayList<Account>();
	}
	
	//Must be a better way of doing this! - Link to already existing accountList??
	public Customer(String fName, String lName, String address, Account acc1, Account acc2)
	{
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.accList = new ArrayList<Account>();
		this.accList.add(acc1);
		this.accList.add(acc2);	
	}
	
	public Customer(String fName, String lName, String address, Account acc1)
	{
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.accList = new ArrayList<Account>();
		this.accList.add(acc1);	
	}
	/*
	 * Add an account only if the use does not
	 * already have 2 accounts. Redundant check.
	 */
	public boolean addAccount(Account c){
		if(this.accList.size() == 2){
			return false;
		}else{
			return this.accList.add(c);		
		}
	}
	
	public int getNumOfAccounts(){
		return this.accList.size();
	}
	
	public String toString()
	{
		return this.fName + " " + this.lName + " " + this.address;
	}
	
}
