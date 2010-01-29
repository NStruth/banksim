package com.uni.queue;

import com.main.account.Transaction;
import com.uni.customer.Customer;

public class QueueItem {

	Customer c;
	Transaction d;
	
	public QueueItem(Customer c, Transaction d){
		this.c = c;
		this.d = d;
	}
	
	public Transaction getTransaction(){
		return d;
	}
}
