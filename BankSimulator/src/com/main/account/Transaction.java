package com.main.account;

import java.util.Enumeration;

public class Transaction {

	public enum Choices {
		OPEN,
		CLOSE,
		DEPOSIT,
		WITHDRAW
	}
	
	private Choices choice;
	private int aux; //money value will be stored here (e.g. withdraw £20)
	
	public Transaction(Choices c, int aux){
		this.choice = c;
		this.aux = aux;
	}
	
	public Transaction.Choices getChoice(){
		return choice;
	}
	
	
	
}
