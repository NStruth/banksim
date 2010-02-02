package com.uni.customer;

import java.util.ArrayList;

import com.main.account.Account;

public class Customer {

	String fName, lName;
	String address;
	ArrayList<Account> accList;
		
	public Customer(String fName, String lName){
		this.fName = fName;
		this.lName = lName;
		this.accList = new ArrayList<Account>();
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
	
}
