package com.uni.Teller;

import com.uni.Exceptions.NonExistantAccountException;
import com.uni.Logging.Language;
import com.uni.Logging.Log;
import com.uni.account.Account;
import com.uni.account.AccountList;
import com.uni.account.Transaction;
import com.uni.account.TransactionList;
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
				message += Language.WITHDRAW_START;
				message +=Language.CustomerInfo(cust.getFullName(), q.getCustNo() +"", acNo+"");
				value = (Integer)t.getPrimaryAux();
				
				//int acNumber = cust.getAccountNo(acNo);
				message += doWithdraw(acNo, value);
				message += Language.TRANSACTION_END;
				break;
			case DEPOSIT:
				message += Language.DEPOSIT_START;
				acNo = (Integer)t.getSecondaryAux();
				message +=Language.CustomerInfo(cust.getFullName(), q.getCustNo() +"", acNo+"");
				try{
					Statistics.ACCOUNT_DEPOSIT++;
					ac = this.al.getAccountAtIndex(acNo);
					value = (Integer)t.getPrimaryAux();
					ac.deposit(value);
					Statistics.TOTALS_DEPOSTIT += value;
					message += Language.DepositInfo(value, ac.getBalance());
				}catch(NonExistantAccountException e){
					message += Language.ERROR_NONEXISTANT_ACCOUNT;
				}
				message += Language.TRANSACTION_END;
				break;
			case OPEN:
				Statistics.ACCOUNTS_OPENED++;
				message += Language.OPEN_START;
				Account acc = new Account();
				al.add(acc);
				cust.addAccount(acc.getAccountNumber());
				message += Language.CustomerInfo(cust.getFullName(), q.getCustNo() +"", acc.getAccountNumber()+"");
				message += Language.TRANSACTION_END;
				break;
			case CLOSE:
				//update statistics
				Statistics.ACCOUNTS_CLOSED++;
				//some boring log stuff
				message += Language.CLOSE_START;
				//get the id of the account (0 or 1)
				int acId = (Integer)t.getPrimaryAux();
				//get the associated account number
				acNo = cust.getAccountNo(acId);
				message +=Language.CustomerInfo(cust.getFullName(), q.getCustNo() +"", acNo+"");
				//remove from account list and customers accounts
				message += "\t" + Language.WITHDRAW_START;
				try{
					int bal = al.getAccountAtIndex(acNo).getBalance();
					message += doWithdraw(acNo, bal);	
					message +=Language.CustomerInfo(cust.getFullName(), q.getCustNo() +"", acNo+"");
					al.removeAccountNo(acNo);
					cust.removeAccount(acId);
				}catch(NonExistantAccountException e){
					message += Language.ERROR_NONEXISTANT_ACCOUNT;
				}
				message += "\t" + Language.TRANSACTION_END;
				//message
				message += Language.TRANSACTION_END;
				break;
			}
			//write the message
			Log.writeMessage(message);
		}
		//another customer served
		Statistics.CUSTOMERS_SERVED++;
		
	}
	
	private String doWithdraw(int acNo, int value){
		Account ac;
		String message;
		try{
			//get the account
			ac = this.al.getAccountAtIndex(acNo);
			//the amount to be withdrawn
			//if the withdraw is successfull report
			if(ac.withDraw(value)){
				Statistics.TOTALS_WITHDRAW += value;
				message = Language.WithdrawInfo(value, ac.getBalance());
			}else{
				message = Language.ERROR_INSUFFICIENT_FUNDS;

			}
			Statistics.ACCOUNT_WITHDRAW++;
			
		}catch(NonExistantAccountException e){
			return Language.ERROR_NONEXISTANT_ACCOUNT;
		}
		return message;
	}
}
