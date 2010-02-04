/*This class will randomly generate a queue
from a list of customers */
package com.uni.main;

import java.util.Random;

import com.main.account.Transaction;
import com.uni.customer.Customer;
import com.uni.customer.CustomerList;
import com.uni.queue.CustomerQueue;
import com.uni.queue.QueueItem;

public class Generator {
	CustomerList list;
	
	public Generator(CustomerList list)
	{
		this.list = list;
	}
	
	
	public QueueItem generateItem()
	{
		Random rGen = new Random();
		int cNo = rGen.nextInt(list.size());
		Customer c = list.get(cNo);
		Transaction t = getTransaction(c);
		QueueItem q = new QueueItem(c, t);
		
		return q;
	}
	
	private Transaction getTransaction(Customer c)
	{
		int cWeight, oWeight, dWeight, wWeight = 0;
		if(c.getNumOfAccounts() == 0)
		{
			oWeight = 100;
		}
	}
	
	public CustomerQueue generate(CustomerList l)
	{
		Random randGen = new Random();
		int length = randGen.nextInt(l.size()) + 1;
		for(int i = 0; i < length; i++)
		{
			
		}
		
		
	}

}
