package com.uni.main;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.uni.Logging.Log;
import com.uni.Teller.Teller;
import com.uni.customer.Customer;
import com.uni.customer.CustomerList;
import com.uni.file.FileIO;
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
				
		/*CustomerQueue<QueueItem> cq = new CustomerQueue<QueueItem>();
		
		//tester data
		Customer c = new Customer("Jon", "Mirhadi");
		Customer d = new Customer("Neil", "Struth");
		Customer e = new Customer("Katy", "Perry");
		
		Transaction t = new Transaction(Transaction.Choices.OPEN);
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
		
			
	
		Account tester = new Account(100);*/
		Log.clearLog();
		
		
		//TODO Neil, i've added a CustomerList class...
		//fancy reading that input from a file too ?
		//tester data
		Customer c = new Customer("Jon", "Mirhadi", "address");
		Customer d = new Customer("Neil", "Struth", "address");
		Customer e = new Customer("Katy", "Perry", "address");
		
		FileIO filehandle = new FileIO("data/accounts.txt","data/customers.txt");
		
		AccountList al = filehandle.readAccountLines();
		CustomerList cl = filehandle.readCustomerLines();
		Log.writeMessage("DISPLAYING CUSTOMER LIST");
		cl.print();
		
		//this just adds the association between customer and account
		c.addAccount(al.get(0));
		d.addAccount(al.get(1));
		e.addAccount(al.get(0));
		
		//create a queue
		//That class needs to keep track of a customer queue number
		//look in that class and read my comments there.
		CustomerQueue<QueueItem> cq = new CustomerQueue<QueueItem>();
		
		//a couple of test transactions
		//Maybe the transaction should have no knowledge of the account though
		//and instead a "0" or a "1" for customers primary account/secondary account
		Transaction t = new Transaction(Transaction.Choices.WITHDRAW, 10, al.get(0));
		Transaction t2 = new Transaction(Transaction.Choices.DEPOSIT, 100, al.get(1));
		
		QueueItem qi = new QueueItem(c, t);
		cq.add(qi);
		qi = new QueueItem(d, t2);
		cq.add(qi);
		
		Teller teller = new Teller();

		int size = cq.size();
		for(int i=0; i<size;i++){
			teller.processQueueItem(cq.get(i));
		}
		
		//al.openAccount(tester);
		/*al.get(0).deposit(100);
		al.get(0).withDraw(250);
		al.get(0).displayBalance();
		al.get(0).withDraw(100);*/
	}
}
