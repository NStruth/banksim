/*This class will randomly generate a queue
from a list of customers - Neil Struth */
package com.uni.main;

import java.text.DecimalFormat;
import java.util.Random;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
import com.main.account.TransactionList;
import com.uni.Exceptions.NonExistantAccountException;
import com.uni.Logging.Log;
import com.uni.customer.Customer;
import com.uni.customer.CustomerList;
import com.uni.queue.CustomerQueue;
import com.uni.queue.QueueItem;

public class Generator {
	CustomerList clist;
	AccountList aList;
	
	public Generator(CustomerList clist, AccountList alist)
	{
		this.clist = clist;
		this.aList = alist;
	}
		
	private QueueItem generateItem()
	{
		Random rGen = new Random();
		int cNo = rGen.nextInt(clist.size());
		Customer c = clist.get(cNo);
		if(c.getStatus() == 0)
		{
			c.setStatus(1);
			
			//1,2,3 transactions with weighted selection
			int numTransWeighted = rGen.nextInt(10);
			//make a list to store the transactions
			TransactionList tList = new TransactionList();
			//generate between 1 and 3 transactions - inclusive
			int numTrans;
			if(numTransWeighted >= 0 &&  numTransWeighted < 5){
				numTrans = 0;
			}else if(numTransWeighted >= 5 && numTransWeighted < 8){
				numTrans = 1;
			}else{
				numTrans = 2;
			}
			
			//generate each transaction
			for(int i=0; i<= numTrans; i++){
				//if they are closing there only account they wont want a new one
				if(tList.containsClose() && c.getNumOfAccounts() == 1){
					break;
				//if they are closing all there accounts the are leaving
				}else if(tList.containsMultipleClose()){
					break;
				//if they are closing 1 account but have 2 then treat transaction as single account
				}else if(tList.containsClose() && c.getNumOfAccounts() == 2){
					tList.add(getTransaction(c, -1));
				//otherwise get the transaction
				}else{
					tList.add(getTransaction(c,0));		
				}
			}
			QueueItem q = new QueueItem(c, tList);
			return q;	
		}else{
			QueueItem q = generateItem();
			return q;
		}
	}
		
	private Transaction getTransaction(Customer c, int accountOffset)
	{
		Random rGen = new Random();
		int cWeight, oWeight, dWeight = 0;
		int totalWeight = 100;
		int tType = rGen.nextInt(100) + 1;
		int accounts = c.getNumOfAccounts() + accountOffset;
		switch(accounts)
		{
			case 0:
			{
				Transaction t = new Transaction(Transaction.Choices.OPEN);
				return t;
			}
			case 1:
			{
				cWeight = 5;
				oWeight = 5;
				dWeight = 45;
				if(tType > 0 && tType <= cWeight)
				{
					return generateClose(0);
				}
				else if(tType > cWeight && tType <= oWeight + cWeight){
					return new Transaction(Transaction.Choices.OPEN);
				}else if(tType > oWeight + cWeight && tType <= dWeight + oWeight + cWeight){
					return generateDeposit(c,rGen, c.getAccountNo(0));
				}else if(tType > dWeight + oWeight + cWeight && tType <= totalWeight){
					return generateWithdraw(c, c.getAccountNo(0));
				}
				break;
			}
			case 2:
			{
				cWeight = 10;
				dWeight = 45;
				if(tType > 0 && tType <= cWeight){
					int accId = rGen.nextInt(2);
					return generateClose(accId);
				}else if(tType > cWeight && tType <= dWeight + cWeight){
					int accId = rGen.nextInt(2);
					return generateDeposit(c,rGen, c.getAccountNo(accId));
				}else if(tType > dWeight + cWeight && tType <= totalWeight){
					int accId = rGen.nextInt(2);
					return generateWithdraw(c, c.getAccountNo(accId));
				}else{
					return null;
				}	
			}
			default:
			{
				cWeight = -1;
				oWeight = -1;
				dWeight = -1;
				return null;
			}
		}
		return null;
		
	}
	

	/**
	 * 
	 * @param c the customer 
	 * @param acc the account number
	 * @return the amount to be withdrawn
	 */
	private int getWithdrawAmount(Customer c, int acc)
	{
		try{
			Account a = aList.getAccountAtIndex(acc);
			a.toString();
			Random rGen = new Random();
		
			if(a.getBalance() < 20000){
				int amount = rGen.nextInt(20000);
				return amount;
			}
			else{
				int amount = rGen.nextInt(20001);
				return amount;
			}
		}catch(NonExistantAccountException e){
			return 0;
		}
		
	}
	
	public CustomerQueue generate()
	{
		CustomerQueue q = new CustomerQueue();
		Random randGen = new Random();
		int length = randGen.nextInt(this.clist.size()) + 1;
		
		//Make sure we have enough customers in the queue
		//Minimum length 5
		if(length < 5)
		{
			length = length + 5;
		}
		for(int i = 0; i < length; i++)
		{
			q.add(generateItem());
		}
		return q;
	}
	
	private Transaction generateDeposit(Customer c, Random rGen, int accNo){
		return  new Transaction(Transaction.Choices.DEPOSIT, rGen.nextInt(10000), accNo);
	}
	
	private Transaction generateClose(int accId){
		return new Transaction(Transaction.Choices.CLOSE, accId);
	}

	private Transaction generateWithdraw(Customer c, int accId ){
		return new Transaction(Transaction.Choices.WITHDRAW, getWithdrawAmount(c, accId), accId);
	}

}
