package com.main.account;

import java.util.ArrayList;


public class AccountList extends ArrayList<Account>{

	public void openAccount(Account ac){
		this.add(ac.getId(), ac);
	}
	
	public void closeAccountAt(int index){
		this.remove(index);
	}
	
	public void closeAccount(Account ac){
		this.remove(ac);
	}
	
	public String toString(){
		String retV = "\nPrinting account list\n";
		for(Account a: this){
			retV = retV + a.toString() + "\n";
		}
		return retV;
	}
	
	public Account getAccountAtIndex(int index){
		for(Account a: this){
			if(a.getId() == index){
				return a;
			}
		}
		return null;
	}
	
	//void editAccount ???
	
}
