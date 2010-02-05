package com.uni.customer;

import java.util.ArrayList;

import com.main.account.Account;

public class Customer {

	String fName, lName;
	String address;
	ArrayList<Integer> accList;
		
	public Customer(String fName, String lName, String address){
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.accList = new ArrayList<Integer>();
	}
	
	/*
	 * Add an account only if the use does not
	 * already have 2 accounts. Redundant check.
	 */
	public boolean addAccount(int c){
		if(this.accList.size() == 2){
			return false;
		}else{
			return this.accList.add(c);		
		}
	}
	
	public String getFullName(){
		return fName + " " + lName;
	}
	
	public int getNumOfAccounts(){
		return this.accList.size();
	}
	
	public int getAccountId(int id)
	{
		if(this.getNumOfAccounts() > id)
		{
			return this.accList.get(id);
		}
		else return -1;

	}
	
	public String toString()
	{
		return this.fName + " " + this.lName + " " + this.address;
	}
	
}
