package com.uni.file;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.main.account.Account;
import com.main.account.AccountList;
import com.uni.customer.Customer;
import com.uni.customer.CustomerList;

public class FileIO {
	
	String afilename;
	String cfilename;
	
	//Constructor
	public FileIO(String afilename, String cfilename)
	{
		this.afilename = afilename;
		this.cfilename = cfilename;
	}
	
	public AccountList readAccountLines()
	{
		try
		{
			File file = new File(afilename);
			Scanner scanner = new Scanner(file);
			AccountList list = new AccountList();
			
			scanner.useDelimiter("\r\n");
			while(scanner.hasNext())
			{
				list.add(parseAccountLine(scanner.next()));
			}
			return list;
		}
		catch(FileNotFoundException e){return null;}
	}
	
	private Account parseAccountLine(String line)
	{
			String id;
			double balance;
			Scanner lScanner = new Scanner(line);
			
			lScanner.useDelimiter("::");
			id = lScanner.next();
			balance = lScanner.nextDouble();
			Account a = new Account(balance, id);
			return a;
	}
	
	public CustomerList readCustomerLines()
	{
		try{
			File file = new File(cfilename);
			Scanner scanner = new Scanner(file);
			CustomerList cList = new CustomerList();
			scanner.useDelimiter("\r\n");
			while(scanner.hasNext())
			{
				cList.add(parseCustomerLine(scanner.next()));
			}
			return cList;
		}
		catch(FileNotFoundException e){return null;}
	}
			
	private Customer parseCustomerLine(String line)
	{
		String fName, lName, address, id1, id2;
		double balance1, balance2;
		Scanner lScanner = new Scanner(line);
		
		lScanner.useDelimiter("::");
		fName = lScanner.next();
		lName = lScanner.next();
		address = lScanner.next();
		if(lScanner.hasNext())
		{
			id1 = lScanner.next();
			balance1 = lScanner.nextDouble();
			Account acc1 = new Account(balance1, id1);
			
			if(lScanner.hasNext())
			{
				id2 = lScanner.next();
				balance2 = lScanner.nextDouble();
				Account acc2 = new Account(balance2, id2);
				Customer cust = new Customer(fName, lName, address,acc1, acc2);
				return cust;
			}
			else
			{
				Customer cust = new Customer(fName, lName, address,acc1);
				return cust;
			}
		}
		else
		{
			Customer cust = new Customer(fName, lName, address);
			return cust;
		}	
	
	}
			
		
		
	}
	
