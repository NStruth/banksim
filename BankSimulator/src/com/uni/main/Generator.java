/*This class will randomly generate a queue
from a list of customers */
package com.uni.main;

import java.util.Random;

import com.main.account.Account;
import com.main.account.AccountList;
import com.main.account.Transaction;
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
	
	
	public QueueItem generateItem()
	{
		Random rGen = new Random();
		int cNo = rGen.nextInt(clist.size());
		Customer c = clist.get(cNo);
		Transaction t = getTransaction(c);
		QueueItem q = new QueueItem(c, t);
		
		return q;
	}
	
	//Horrible I know!!! The other way i thought of doing it was to keep the weights in an
	//Array and sort them first... The only thing with that method is that you dont keep track of 
	//which one is which. Two-dimensional array would be the obvious solution. Ill think about it later...Neil
	
	private Transaction getTransaction(Customer c)
	{
		Random rGen = new Random();
		int cWeight, oWeight, dWeight, wWeight = 0;
		int totalWeight = 100;
		int tType = rGen.nextInt(100) + 1;
		switch(c.getNumOfAccounts())
		{
			case 0:
			{
				Transaction t = new Transaction(Transaction.Choices.OPEN, c);
				return t;
			}
			case 1:
			{
				cWeight = 5;
				oWeight = 5;
				dWeight = 45;
				wWeight = 45;
				if(tType > 0 && tType <= cWeight)
				{
					Transaction t = new Transaction(Transaction.Choices.CLOSE, c);
					return t;
				}
				else
				{
					if(tType > cWeight && tType <= oWeight + cWeight)
					{
						Transaction t = new Transaction(Transaction.Choices.OPEN, c);
						return t;
					}
					else
					{
						if(tType > oWeight + cWeight && tType <= dWeight + oWeight + cWeight)
						{
							Transaction t = new Transaction(Transaction.Choices.DEPOSIT, rGen.nextInt(200), c.getAccountId(0));
							return t;
						}
						else
						{
							if(tType > dWeight + oWeight + cWeight && tType <= totalWeight)
							{
								Transaction t = new Transaction(Transaction.Choices.WITHDRAW, getWithdrawAmount(c, c.getAccountId(0)), c.getAccountId(0));
								return t;
							}
						}
					}
				}
				break;
			}
			case 2:
			{
				cWeight = 10;
				dWeight = 45;
				wWeight = 45;
				if(tType > 0 && tType <= cWeight)
				{
					Transaction t = new Transaction(Transaction.Choices.CLOSE, c);
					return t;
				}
				else
				{
					if(tType > cWeight && tType <= dWeight + cWeight)
					{
						int accNo = rGen.nextInt(2);
						Transaction t = new Transaction(Transaction.Choices.DEPOSIT, rGen.nextInt(200), c.getAccountId(accNo));
						return t;
					}
					else
					{
						if(tType > dWeight + cWeight && tType <= totalWeight)
						{
							int accNo = rGen.nextInt(2);
							Transaction t = new Transaction(Transaction.Choices.WITHDRAW, getWithdrawAmount(c, c.getAccountId(accNo)), c.getAccountId(accNo));
							return t;
						}
						else
						{
							return null;
						}
					}
				}
			}
			default:
			{
				cWeight = -1;
				oWeight = -1;
				dWeight = -1;
				wWeight = -1;
				return null;
			}
		}
		return null;
		
	}
	
	public int getWithdrawAmount(Customer c, int acc)
	{
		Account a = aList.getAccountAtIndex(acc);
		a.toString();
		Random rGen = new Random();
	
		if(a.getBalance() < 200)
		{
			return rGen.nextInt((int) a.getBalance()) + 1;
		}
		else
			return rGen.nextInt(201);
	}
	
	public CustomerQueue generate()
	{
		CustomerQueue q = new CustomerQueue();
		Random randGen = new Random();
		int length = randGen.nextInt(this.clist.size()) + 1;
		for(int i = 0; i < length; i++)
		{
			q.add(generateItem());
		}
		return q;
	}

}
