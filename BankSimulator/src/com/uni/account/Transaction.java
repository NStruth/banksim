package com.uni.account;

import com.uni.customer.Customer;

public class Transaction {

	public int ac;
	
	public enum Choices {
		OPEN,
		CLOSE,
		DEPOSIT,
		WITHDRAW
	}
	
	private Choices choice;
	private Object primaryAux; //
	private Object secondaryAux;
	
	/*
	 * Constructor when withdrawing money
	 */
	public Transaction(Choices c, int aux, int ac){
		this.choice = c;
		this.primaryAux = aux;
		this.secondaryAux = ac;
	}
	
	/*
	 * Constructor for closing an account
	 */
	public Transaction(Choices c, int ac)
	{
		this.choice = c;
		this.primaryAux = ac;
	}

	/* Constructor to be used when opening an account */
	public Transaction(Choices c){
		this.choice = c;
	}
	
	/* Constructor to be used when opening a joint account */
	public Transaction(Choices c, Customer first, Customer second)
	{
		this.choice = c;
		this.primaryAux = first;
		this.primaryAux = second;
	}
	
	public Transaction.Choices getChoice(){
		return choice;
	}
	
	public Object getPrimaryAux() {
		return primaryAux;
	}

	public Object getSecondaryAux() {
		return secondaryAux;
	}
	
}
