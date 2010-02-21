package com.uni.main;

import com.uni.Logging.Log;
import com.uni.Teller.Teller;
import com.uni.account.AccountList;
import com.uni.customer.CustomerList;
import com.uni.file.FileIO;
import com.uni.gui.GuiDisplay;
import com.uni.queue.CustomerQueue;

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
		
		/* Generate a random queue */
		Generator g = new Generator(cl, al);
		Log.writeMessage(al.toString());
		Log.writeMessage("DISPLAYING CUSTOMER LIST");
		cl.print();
					
		CustomerQueue cq = g.generate();
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
