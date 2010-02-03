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
			int id;
			double balance;
			Scanner lScanner = new Scanner(line);
			
			lScanner.useDelimiter("::");
			id = Integer.parseInt(lScanner.next());
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
			scanner.useDelimiter("\n");
			while(scanner.hasNext())
			{
				cList.add(parseCustomerLine(scanner.next()));
			}
			return cList;
		}
		catch(FileNotFoundException e){return null;}
	}
			
	private Customer parseCustomerLine(String line){
		String fName, lName, address;
		Scanner lScanner = new Scanner(line);
		Customer cust;
		
		lScanner.useDelimiter("::");
		fName = lScanner.next();
		lName = lScanner.next();
		address = lScanner.next();
		cust = new Customer(fName,lName, address);
		
		if(lScanner.hasNext()){
			int ac1 = lScanner.nextInt();
			cust.addAccount(ac1);
		}
		
		if(lScanner.hasNext()){
			int ac2 = lScanner.nextInt();
			cust.addAccount(ac2);
		}
		
		return cust;	
	}
			
		
}
	
