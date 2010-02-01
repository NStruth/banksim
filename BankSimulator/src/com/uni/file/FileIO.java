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
			
		
		
	}
	
