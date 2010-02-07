package com.uni.customer;

import java.util.ArrayList;

import com.main.account.Account;
import com.uni.Logging.Log;

public class Customer {

	String fName, lName;
	String address;
	ArrayList<Integer> accList;
	
	//Status indicates whether customer is in the queue or not
	//0 = not 1 = in queue
	//initially a customer is not in the queue
	private int status = 0;
		
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
	
	public int getStatus()
	{
		return this.status;
	}
	
	public void setStatus(int s)
	{
		this.status = s;
	}
	
	public String getFullName(){
		return fName + " " + lName;
	}
	
	public int getNumOfAccounts(){
		return this.accList.size();
	}
	
	public int getAccountId(int id)
	{
		if(this.getNumOfAccounts() >= id)
		{
			return this.accList.get(id);
		}
		else return -1;

	}
	
	public void addAccount(Account ac)
	{
		if(this.getNumOfAccounts() < 2)
		{
			this.accList.add(ac.getId());
			Log.writeMessage("Account Number: "+ ac.getId() + " added to customer : " + this.getFullName());
		}
	}
	
	public void removeAccount(int id)
	{
		if(this.getNumOfAccounts() >= id)
		{
			Log.writeMessage("AccountNo : " + this.getAccountId(id) + " removed\n");
			this.accList.remove(id);	
		}
		else
			Log.writeMessage("Invalid ID");
		
	}
	
	public String toString()
	{
		return this.fName + " " + this.lName + " " + this.address;
	}
	
}
