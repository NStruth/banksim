package com.uni.queue;

import com.uni.account.Transaction;
import com.uni.account.TransactionList;
import com.uni.customer.Customer;

public class QueueItem {

	public static int masterNumber = 1000;
	Customer c;
	Transaction d;
	int custId;
	
	TransactionList tList;
	
	public QueueItem(Customer c, Transaction d){
		this.c = c;
		this.d = d;
		masterNumber++;
		this.custId = masterNumber;
	}
	
	public QueueItem(Customer c, TransactionList tList){
		this.c = c;
		this.tList = tList;
		masterNumber++;
		this.custId = masterNumber;
	}
	
	public TransactionList getTransactions(){
		return this.tList;
	}
	
	
	//dep
	public Transaction getTransaction(){
		return d;
	}
	
	public Customer getCustomer(){
		 return this.c;
	}
	
	public int getCustNo(){
		return this.custId;
	}
}
