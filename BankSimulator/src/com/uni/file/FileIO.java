package com.uni.file;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.uni.account.Account;
import com.uni.account.AccountList;
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
			File file = new File(afilename); //REMOVE
			Scanner scanner = new Scanner(file); //REMOVE
			/*InputStream in = getClass().getResourceAsStream
			  (afilename);
			  Scanner scanner = new Scanner(in);*/
			AccountList list = new AccountList();
			
			scanner.useDelimiter("\r\n");//look into
			while(scanner.hasNext())
			{
				list.add(parseAccountLine(scanner.next()));
			}
			scanner.close();
			return list;
		}
		catch(FileNotFoundException e){return null;}
		//catch(Exception e){return null;}
	}
	
	private Account parseAccountLine(String line)
	{
			int id;
			int balance;
			Scanner lScanner = new Scanner(line);
			
			lScanner.useDelimiter("::");
			id = Integer.parseInt(lScanner.next());
			balance = lScanner.nextInt();
			Account a = new Account(balance, id);
			return a;
	}
	
	public CustomerList readCustomerLines()
	{
		try{
			File file = new File(cfilename);//REMOVE
			Scanner scanner = new Scanner(file);//REMOVE
			/*InputStream in = getClass().getResourceAsStream
			  (cfilename);
			  Scanner scanner = new Scanner(in);*/
			CustomerList cList = new CustomerList();
			scanner.useDelimiter("\n");
			while(scanner.hasNext())
			{
				cList.add(parseCustomerLine(scanner.next()));
			}
			return cList;
		}
		catch(FileNotFoundException e){return null;}
		//catch(Exception e) {return null;}
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
	
