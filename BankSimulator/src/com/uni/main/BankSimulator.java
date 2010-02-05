package com.uni.main;

import java.util.Random;
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
				
		
		Log.clearLog();
		
		
		//TODO Neil, i've added a CustomerList class...
		//fancy reading that input from a file too ?
		//tester data
		
		FileIO filehandle = new FileIO("data/accounts.txt","data/customers.txt");
		
		AccountList al = filehandle.readAccountLines();
		CustomerList cl = filehandle.readCustomerLines();
		Generator g = new Generator(cl, al);
		Log.writeMessage(al.toString());
		Log.writeMessage("DISPLAYING CUSTOMER LIST");
		cl.print();
				
		//create a queue
		//That class needs to keep track of a customer queue number
		//look in that class and read my comments there.
		//CustomerQueue cq = new CustomerQueue();
		
		CustomerQueue cq = g.generate();
		
		//a couple of test transactions
		//Maybe the transaction should have no knowledge of the account though
		//and instead a "0" or a "1" for customers primary account/secondary account - me likey! Neil
		//Transaction t = new Transaction(Transaction.Choices.WITHDRAW, 10, 60001);
		//Transaction t2 = new Transaction(Transaction.Choices.DEPOSIT, 100, 60002);
		
		//QueueItem qi = new QueueItem(cl.get(0), t);
		//cq.add(qi);
		//qi = new QueueItem(cl.get(1), t2);
		//cq.add(qi);
		
		Teller teller = new Teller(al);

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
