package com.uni.Teller;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.main.account.TransactionList;
import com.uni.Exceptions.NonExistantAccountException;
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


			switch(t.getChoice()){
			case WITHDRAW:
				acNo = (Integer)t.getSecondaryAux();
				//some message stuff
				message += "*** Processing withdraw transaction ***\n";
				message +="Customer: " + cust.getFullName() + " No: " + q.getCustNo() + "Acc:" + acNo;
				try{
					//get the account
					ac = this.al.getAccountAtIndex(acNo);
					//the amount to be withdrawn
					value = (Integer)t.getPrimaryAux();
					//if the withdraw is successfull report
					if(ac.withDraw(value)){
						Statistics.TOTALS_WITHDRAW += value;
					}
					Statistics.ACCOUNT_WITHDRAW++;

					message +="\n*** End of Transaction ***\n\n";
				}catch(NonExistantAccountException e){
					message += "Sorry that account doesn't exist";
				}
				break;
			case DEPOSIT:
				message += "*** Processing deposit Transaction***\n\n";
				acNo = (Integer)t.getSecondaryAux();
				message +="Customer: " + cust.getFullName() + " No: " + q.getCustNo() + "Acc:" + acNo;
				try{
					Statistics.ACCOUNT_DEPOSIT++;
					ac = this.al.getAccountAtIndex(acNo);
					value = (Integer)t.getPrimaryAux();
					ac.deposit(value);
					Statistics.TOTALS_DEPOSTIT += value;
				}catch(NonExistantAccountException e){
					message += "Sorry that account doesn't exist";
				}
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
				//update statistics
				Statistics.ACCOUNTS_CLOSED++;
				//some boring log stuff
				message += "\n*** Processing close Transaction ***\n";
				message += "Customer = "+ cust.getFullName();
				message += "PrimaryAux = " + (Integer)t.getPrimaryAux();
				//get the id of the account (0 or 1)
				int acId = (Integer)t.getPrimaryAux();
				//get the associated account number
				acNo = cust.getAccountNo(acId);
				//remove from account list and customers accounts
				al.removeAccountNo(acNo);
				cust.removeAccount(acId);
				//message
				message += "\n*** End of Transaction ***\n";
				break;
			}
			//write the message
			Log.writeMessage(message);
		}
		//another customer served
		Statistics.CUSTOMERS_SERVED++;
		
	}
}
