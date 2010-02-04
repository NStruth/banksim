package com.uni.queue;

import com.main.account.Transaction;
import com.uni.customer.Customer;

public class QueueItem {

	public static int masterNumber = 1000;
	Customer c;
	Transaction d;
	int custId;
	
	public QueueItem(Customer c, Transaction d){
		this.c = c;
		this.d = d;
		masterNumber++;
		this.custId = masterNumber;
	}
	
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
