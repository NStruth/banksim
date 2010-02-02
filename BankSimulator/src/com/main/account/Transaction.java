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
	
	//Should we not have two constructors one for the monetry quatification
	//and a second where we dont need one like:
	public Transaction(Choices c, int aux){
		this.choice = c;
		this.aux = aux;
	}
	public Transaction(Choices c)
	{
		this.choice = c;
	}
	
	public Transaction.Choices getChoice(){
		return choice;
	}
	
	
	
}
