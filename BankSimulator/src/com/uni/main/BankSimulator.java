package com.uni.main;

import com.main.account.AccountList;
import com.uni.Logging.Log;
import com.uni.Teller.Teller;
import com.uni.customer.CustomerList;
import com.uni.file.FileIO;
import com.uni.gui.GuiDisplay;
import com.uni.queue.CustomerQueue;

public class BankSimulator {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		
		
		Log.clearLog();
		
		
		//read in list of accounts and customers
		FileIO filehandle = new FileIO("data/accounts.txt","data/customers.txt");
		AccountList al = filehandle.readAccountLines();
		CustomerList cl = filehandle.readCustomerLines();
		
		/* Generate a random queue */
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
		//Transaction t = new Transaction(Transaction.Choices.CLOSE, 0);
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
		
		GuiDisplay gd = new GuiDisplay();
		//al.openAccount(tester);
		/*al.get(0).deposit(100);
		al.get(0).withDraw(250);
		al.get(0).displayBalance();
		al.get(0).withDraw(100);*/
	}
}
