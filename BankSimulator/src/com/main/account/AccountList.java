package com.main.account;

import java.util.ArrayList;


public class AccountList extends ArrayList<Account>{

	public void openAccount(Account ac){
		this.add(ac);
	}
	
	public void closeAccountAt(int index){
		this.remove(index);
	}
	
	public void closeAccount(Account ac){
		this.remove(ac);
	}
	
	//public int getAccountIndex(Account ac)
	
	//void editAccount ???
	
}
