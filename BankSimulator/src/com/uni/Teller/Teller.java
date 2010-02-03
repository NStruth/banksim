package com.uni.Teller;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.uni.Logging.Log;
import com.uni.customer.Customer;
import com.uni.queue.QueueItem;

public class Teller {
	
	AccountList al;

	public Teller(AccountList al){
		this.al = al;
	}
	
	public void processQueueItem(QueueItem q){
		Transaction t = q.getTransaction();
		Customer cust = q.getCustomer();
		
		int acNo;
		Account ac;
		Integer value; //can't cast object to int
		
		
		//some of this will have repeated code so we should try do the generic stuff 
		//before the switch or in a method
		switch(t.getChoice()){
		case WITHDRAW:
			Log.writeMessage("*** Processing withdraw transaction ***\n");
			Log.writeMessage("Customer: " + cust.getFullName());
			acNo = (Integer)t.getSecondaryAux();
			ac = this.al.getAccountAtIndex(acNo);
			value = (Integer)t.getPrimaryAux();
			ac.withDraw(value);
			Log.writeMessage("\n***End of Transaction***\n");
			break;
		case DEPOSIT:
			Log.writeMessage("*** Processing deposit Transaction***\n");
			Log.writeMessage("Customer: " + cust.getFullName());
			acNo = (Integer)t.getSecondaryAux();
			ac = this.al.getAccountAtIndex(acNo);
			value = (Integer)t.getPrimaryAux();
			ac.deposit(value);
			Log.writeMessage("\n***End of Transaction***\n");
			break;
		case OPEN:
			Log.writeMessage("Processing open Transaction");
			break;
		case CLOSE:
			Log.writeMessage("Processing close Transaction");
			break;
		}		
	}
}
