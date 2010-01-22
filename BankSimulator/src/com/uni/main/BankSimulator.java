package com.uni.main;

import com.main.account.*;
import com.uni.Logging.Log;

public class BankSimulator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Neil is Cool
		System.out.println("Hello Wolrd");
		
		Account tester = new Account(100);
		
		AccountList al = new AccountList();
		al.openAccount(tester);
		al.get(0).deposit(100);
		al.get(0).withDraw(250);
		al.get(0).displayBalance();
		al.get(0).withDraw(100);
	}
}
