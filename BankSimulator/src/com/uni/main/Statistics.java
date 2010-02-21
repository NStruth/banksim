package com.uni.main;

public class Statistics {

	public static int CUSTOMERS_SERVED = 0;
	public static int ACCOUNTS_OPENED = 0;
	public static int ACCOUNTS_CLOSED = 0;
	public static int ACCOUNT_WITHDRAW = 0;
	public static int ACCOUNT_DEPOSIT = 0;
	
	public static int TOTALS_WITHDRAW = 0;
	public static int TOTALS_DEPOSTIT = 0;

	public static String toPoundsAndPence(int value){
		
		int div = value/100;
		char pound = '£';
		
		int remainder = value -(div * 100);
		String rem = "";
		if(remainder<10){
			rem = "0" + remainder;
		}else{
			rem = "" + remainder;
		}
		
		return pound + div + "." + rem;
	}
	
}
