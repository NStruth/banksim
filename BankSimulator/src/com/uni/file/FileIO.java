package com.uni.file;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import com.main.account.Account;
import com.main.account.AccountList;

public class FileIO {
	
	String afilename;
	String cfilename;
	
	//Constructor
	public FileIO(String afilename, String cfilename)
	{
		this.afilename = afilename;
		this.cfilename = cfilename;
	}
	
	public AccountList readAccounts()
	{
		
		try
		{
			
			String id;
			double balance;
			AccountList list = new AccountList();
			File file = new File(afilename);
			Scanner scanner = new Scanner(file);
			
			scanner.useDelimiter("::");
			while(scanner.hasNext())
			{
				id = scanner.next();
				balance = scanner.nextDouble();
				Account a = new Account(balance, id);
				list.add(a);
			}
			return list;
				
			}
		catch(FileNotFoundException e){return null;}
	}
			
		
		
	}
	
