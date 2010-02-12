package com.uni.testing;

import static org.junit.Assert.*;

import org.junit.Test;
import com.main.account.Account;


public class AccountTest {
	
	@Test public void testCreateAccount()
	{
		//Test default
		
		Account acc1 = new Account();
		
		String expected1 = "60001 100.00";
		String actual1 = acc1.toString();
		String message1 = "Create failed for default account";
		
		assertEquals(message1, expected1, actual1);
		
		//Test Conceptual Upper Bound - id 69999 balance 100000.00
		
		Account acc2 = new Account(100000.00, 69999);
		
		String expected2 = "69999 100000.00";
		String actual2 = acc2.toString();
		String message2 = "Create failed for id - 69999 balance 100000.0";
		
		assertEquals(message2, expected2, actual2);
		
		//Test Conceptual Lower Bound - id 60000 balance 0.0
		
		Account acc3 = new Account(0.0, 60000);
		
		String expected3 = "60000 0.00";
		String actual3 = acc3.toString();
		String message3 = "Create failed for id - 60000 balance 0.0";
		
		assertEquals(message3, expected3, actual3);
		
	}
	
	@Test public void testToString()
	{	
		//Test 1 - Middle
		Account acc1 = new Account(123.12, 60012);
		
		String expected1 = "60012 123.12";
		String actual1 = acc1.toString();
		String message1 = "Failed for id 60012, balance 123.12";
		
		assertEquals(message1, expected1, actual1);
		
		//Test 2 - Lower Bound
		Account acc2 = new Account(0.0 , 60000);
		
		String expected2 = "60000 0.00";
		String actual2 = acc2.toString();
		String message2 = "Failed for id 60000, balance 0.0";
		
		assertEquals(message2, expected2, actual2);
		
		//Test 3 - Upper Bound
		
		Account acc3 = new Account (100000.0, 69999);
		
		String expected3 = "69999 100000.00";
		String actual3 = acc3.toString();
		String message3 = "Failed for id 69999, balance 100000.0";
		
		assertEquals(message3, expected3, actual3);
		
		
	}
	
	@Test public void testGetBalance()
	{
		Account acc = new Account();
		
		double expected = 100.0;
		double actual = acc.getBalance();
		String message = "Failed for default account";
		
		assertEquals(message, expected, actual, 0);
	}
	
	@Test public void testGetID()
	{
		Account acc = new Account(50.0, 60001);
		
		int expected = 60001;
		int actual = acc.getId();
		String message = "Failed for account balance = 50.0, id = 60001";
		
		assertEquals(message, expected, actual);
	}
	
	@Test public void testDeposit()
	{
		Account acc = new Account();
		acc.deposit(50.0);
		
		double expected1 = 150.0;
		double actual1 = acc.getBalance();
		String message1 = "Failed for default account - deposit 50.0";
		
		assertEquals(message1, expected1, actual1, 0);	
	}
	
	
	@Test public void testWithdraw()
	{
		Account acc = new Account();
		acc.withDraw(50.0);
		
		double expected1 = 50.0;
		double actual1 = acc.getBalance();
		String message1 = "Failed for default account - withdraw 50.0";
		
		assertEquals(message1, expected1, actual1, 0);
	}

}
