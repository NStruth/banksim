package com.uni.main;

import com.uni.Logging.Log;
import com.uni.Teller.Teller;
import com.uni.account.AccountList;
import com.uni.account.Transaction;
import com.uni.account.TransactionList;
import com.uni.customer.CustomerList;
import com.uni.file.FileIO;
import com.uni.gui.GuiDisplay;
import com.uni.queue.CustomerQueue;
import com.uni.queue.QueueItem;

/**
 * @author Jon Mirhadi
 * @author Neil Struth
 * 
 * @version 1.0
 * 
 * A bank simulator.  A bank is set up with accounts
 * and customers.  A queue is randomly generated with 
 * customers and transactions which are processed by 
 * the teller. Summary results are displayed in a 
 * basic gui as well as a more detailed log file.
 *
 */
public class BankSimulator {
	
	/**
	 * @param args
	 */
	

	
	public static void main(String[] args) {
		//clear the log file				
		Log.clearLog();
		
		//read in list of accounts and customers
		FileIO filehandle = new FileIO("data/accounts.txt","data/customers.txt");
		AccountList al = filehandle.readAccountLines();
		CustomerList cl = filehandle.readCustomerLines();
		
		QueueItem[] testArray = new QueueItem[6];
		
		TransactionList tList0 = new TransactionList();
		tList0.add((new Transaction(Transaction.Choices.DEPOSIT, 10000, cl.get(3).getAccountNo(0))));
		testArray[0] = new QueueItem(cl.get(3), tList0);
		
		TransactionList tList1 = new TransactionList();
		tList1.add(new Transaction(Transaction.Choices.DEPOSIT, 10000, cl.get(0).getAccountNo(0)));
		tList1.add(new Transaction(Transaction.Choices.DEPOSIT, 10000, cl.get(0).getAccountNo(1)));
		testArray[1] = new QueueItem(cl.get(3), tList1);
		
		TransactionList tList2 = new TransactionList();
		tList2.add(new Transaction(Transaction.Choices.WITHDRAW, 50000, cl.get(2).getAccountNo(0)));
		tList2.add(new Transaction(Transaction.Choices.WITHDRAW, 50000, cl.get(2).getAccountNo(0)));
		testArray[2] = new QueueItem(cl.get(2), tList2);
		
		TransactionList tList3 = new TransactionList();
		tList3.add((new Transaction(Transaction.Choices.CLOSE,  0)));
		tList3.add((new Transaction(Transaction.Choices.CLOSE,  0)));
		tList3.add((new Transaction(Transaction.Choices.CLOSE,  0)));
		testArray[3] = new QueueItem(cl.get(5), tList3);
		
		TransactionList tList4 = new TransactionList();
		tList4.add(new Transaction(Transaction.Choices.DEPOSIT, 10000, cl.get(5).getAccountNo(0)));
		testArray[4] = new QueueItem(cl.get(5), tList4);
		
		
		TransactionList tList5 = new TransactionList();
		tList5.add(new Transaction(Transaction.Choices.OPEN));
		tList5.add(new Transaction(Transaction.Choices.OPEN));
		tList5.add(new Transaction(Transaction.Choices.OPEN));
		testArray[5] = new QueueItem(cl.get(4), tList5);
		
		/* Generate a random queue */
		//Generator g = new Generator(cl, al);
		Log.writeMessage(al.toString());
		Log.writeMessage("DISPLAYING CUSTOMER LIST");
		cl.print();
					
		//CustomerQueue cq = g.generate();
		
		CustomerQueue cq = new CustomerQueue();
		for(QueueItem qi: testArray)
		{
			cq.add(qi);	
		}
		/* Set up the teller */
		Teller teller = new Teller(al);
		/* Process the queue */
		int size = cq.size();
		for(int i=0; i<size;i++){
			teller.processQueueItem(cq.get(i));
		}
		//display summary results
		GuiDisplay gd = new GuiDisplay();
	}
}
