package com.uni.testing;

import static org.junit.Assert.*;

import org.junit.Test;
import com.main.account.Account;


public class AccountTest {
	
	@Test public void testToString()
	{
		Account acc = new Account(123.12, 60012);
		
		String expected = "60012 123.12";
		String actual = acc.toString();
		String message = "Failed for id 60012, balance 123.12";
		
		assertEquals(message, expected, actual);
		
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
