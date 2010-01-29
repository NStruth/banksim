package com.uni.main;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.uni.Logging.Log;
import com.uni.Teller.Teller;
import com.uni.customer.Customer;
import com.uni.queue.CustomerQueue;
import com.uni.queue.QueueItem;

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
		CustomerQueue<QueueItem> cq = new CustomerQueue<QueueItem>();
		
		//tester data
		Customer c = new Customer("Jon", "Mirhadi");
		Customer d = new Customer("Neil", "Struth");
		Customer e = new Customer("Katy", "Perry");
		
		Transaction t = new Transaction(Transaction.Choices.OPEN, 0);
		Transaction t2 = new Transaction(Transaction.Choices.WITHDRAW, 10);
		
		QueueItem qi = new QueueItem(c, t);
		cq.add(qi);
		qi = new QueueItem(d, t2);
		cq.add(qi);
		
		Teller teller = new Teller();
		
		int size = cq.size();
		for(int i=0; i<size;i++){
			teller.processQueueItem(cq.get(i));
		}
		
			
	
		Account tester = new Account(100);
		
		AccountList al = new AccountList();
		al.openAccount(tester);
		al.get(0).deposit(100);
		al.get(0).withDraw(250);
		al.get(0).displayBalance();
		al.get(0).withDraw(100);
	}
}
