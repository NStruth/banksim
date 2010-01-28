package com.uni.main;

import com.main.account.Account;
import com.main.account.AccountList;
import com.uni.customer.Customer;
import com.uni.queue.Queue;
import com.uni.Logging.Log;

public class BankSimulator {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		/*Queue<Customer> q = new Queue<Customer>();
		Customer c = new Customer("Jon", "Mirhadi");
		q.push(c);
		c = new Customer("Neil", "Struth");
		q.push(c);*/
				
		Log.clearLog();
		Account tester = new Account(100);
		
		AccountList al = new AccountList();
		al.openAccount(tester);
		al.get(0).deposit(100);
		al.get(0).withDraw(250);
		al.get(0).displayBalance();
		al.get(0).withDraw(100);
	}
}
