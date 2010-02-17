package com.main.account;

import java.util.ArrayList;

public class TransactionList extends ArrayList<Transaction> {
	
	public TransactionList(){
		super();
	}

	@Override
	public boolean add(Transaction t) {
		return super.add(t);
	}
	
	
	//not to be used then
	public boolean containsClose(){
		for(Transaction t: this){
			if(t.getChoice() == Transaction.Choices.CLOSE)
				return true;
		}
		return false;
	}
	
	

}
