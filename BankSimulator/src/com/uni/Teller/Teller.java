package com.uni.Teller;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.main.account.TransactionList;
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
		
		TransactionList tList = q.getTransactions();
		
		Transaction ta = q.getTransaction();
		Customer cust = q.getCustomer();
				
		
		for(Transaction t: tList){
			
			String message = "";
			int acNo;
			Account ac;
			int value; //can't cast object to int
			
			
			//some of this will have repeated code so we should try do the generic stuff 
			//before the switch or in a method
			switch(t.getChoice()){
			case WITHDRAW:
				Statistics.ACCOUNT_WITHDRAW++;
	
				message += "*** Processing withdraw transaction ***\n";
				
				acNo = (Integer)t.getSecondaryAux();
				message +="Customer: " + cust.getFullName() + " No: " + q.getCustNo() + "Acc:" + acNo;;
				ac = this.al.getAccountAtIndex(acNo);
				value = (Integer)t.getPrimaryAux();
				if(ac.withDraw(value)){
					Statistics.TOTALS_WITHDRAW += value;
				}
				message +="\n*** End of Transaction ***\n\n";
				break;
			case DEPOSIT:
				Statistics.ACCOUNT_DEPOSIT++;
				message += "*** Processing deposit Transaction***\n\n";
				
				acNo = (Integer)t.getSecondaryAux();
				message +="Customer: " + cust.getFullName() + " No: " + q.getCustNo() + "Acc:" + acNo;
				ac = this.al.getAccountAtIndex(acNo);
				value = (Integer)t.getPrimaryAux();
				ac.deposit(value);
				Statistics.TOTALS_DEPOSTIT += value;
				message += "\n*** End of Transaction ***\n\n";
				break;
			case OPEN:
				Statistics.ACCOUNTS_OPENED++;
				message +="\n*** Processing open Transaction ***\n";
				Account acc = new Account();
				al.add(acc);
				cust.addAccount(acc);
				message += "\n*** End of Transaction ***\n";
				break;
			case CLOSE:
				Statistics.ACCOUNTS_CLOSED++;
				message += "\n*** Processing close Transaction ***\n";
				message += "Customer = "+ cust.getFullName();
				message += "PrimaryAux = " + (Integer)t.getPrimaryAux();
				message += (Integer)t.getPrimaryAux();
				acNo = (Integer)t.getPrimaryAux();
				cust.removeAccount(acNo);
				
				message += "\n*** End of Transaction ***\n";
				break;
			}
			Log.writeMessage(message);
		}
		Statistics.CUSTOMERS_SERVED++;
		
	}
}
