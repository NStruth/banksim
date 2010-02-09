package com.uni.Teller;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.uni.Logging.Log;
import com.uni.customer.Customer;
import com.uni.main.Statistics;
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
			Statistics.ACCOUNT_WITHDRAW++;

			Log.writeMessage("*** Processing withdraw transaction ***\n");
			Log.writeMessage("Customer: " + cust.getFullName() + " No: " + q.getCustNo());
			acNo = (Integer)t.getSecondaryAux();
			ac = this.al.getAccountAtIndex(acNo);
			value = (Integer)t.getPrimaryAux();
			ac.withDraw(value);
			Log.writeMessage("\n*** End of Transaction ***\n");
			break;
		case DEPOSIT:
			Statistics.ACCOUNT_DEPOSIT++;
			Log.writeMessage("*** Processing deposit Transaction***\n");
			Log.writeMessage("Customer: " + cust.getFullName() + " No: " + q.getCustNo());
			acNo = (Integer)t.getSecondaryAux();
			ac = this.al.getAccountAtIndex(acNo);
			value = (Integer)t.getPrimaryAux();
			ac.deposit(value);
			Log.writeMessage("\n*** End of Transaction ***\n");
			break;
		case OPEN:
			Statistics.ACCOUNTS_OPENED++;
			Log.writeMessage("\n*** Processing open Transaction ***\n");
			Account acc = new Account();
			al.add(acc);
			cust.addAccount(acc);
			Log.writeMessage("\n*** End of Transaction ***\n");
			break;
		case CLOSE:
			Statistics.ACCOUNTS_CLOSED++;
			Log.writeMessage("\n*** Processing close Transaction ***\n");
			Log.writeMessage("Customer = "+ cust.getFullName());
			Log.writeMessage("PrimaryAux = " + (Integer)t.getPrimaryAux());
			cust.removeAccount((Integer)t.getPrimaryAux());
			Log.writeMessage("\n*** End of Transaction ***\n");
			break;
		}	
		
		Statistics.CUSTOMERS_SERVED++;
		
	}
}
