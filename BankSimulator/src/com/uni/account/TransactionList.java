package com.uni.account;

import java.util.ArrayList;

public class TransactionList extends ArrayList<Transaction> {
	
	public TransactionList(){
		super();
	}

	@Override
	public boolean add(Transaction t) {
		return super.add(t);
	}
	
	
	public boolean containsClose(){
		for(Transaction t: this){
			if(t.getChoice() == Transaction.Choices.CLOSE)
				return true;
		}
		return false;
	}

	public boolean containsMultipleClose(){
		int counter = 0;
		for(Transaction t: this){
			if(t.getChoice() == Transaction.Choices.CLOSE){
				counter++;
			}
		}
		if(counter > 1){
			return true;
		}else{
			return false;
		}
	}
	
	

}
