package com.uni.account;

import java.util.ArrayList;

import com.uni.Exceptions.NonExistantAccountException;


public class AccountList extends ArrayList<Account>{

	public void openAccount(Account ac){
		this.add(ac.getAccountNumber(), ac);
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
	
	public Account getAccountAtIndex(int index) throws NonExistantAccountException{
		for(Account a: this){
			if(a.getAccountNumber() == index){	
				return a;
			}
		}
		throw new NonExistantAccountException();
	}
	
	public boolean removeAccountNo(int acNo){
		for(Account a: this){
			if(a.getAccountNumber() == acNo){
				this.remove(a);
				System.out.println("Removing" + a.getAccountNumber());
				return true;
			}
		}
		return false;
	}
	
	//void editAccount ???
	
}
