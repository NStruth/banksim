package com.uni.Logging;

import com.uni.main.Statistics;

public class Language {

	
	public static String WITHDRAW_START = "\n\n *** Processing withdraw transaction *** \n\n";
	public static String DEPOSIT_START = "\n\n *** Processing deposit transaction *** \n\n";
	public static String OPEN_START = "\n\n *** Processing open transaction *** \n\n";
	public static String CLOSE_START = "\n\n *** Processing close transaction ** \n\n";
	
	public static String TRANSACTION_END = "\n *** End of transaction *** \n";
	
	public static String ERROR_NONEXISTANT_ACCOUNT = "Sorry that account doesn't exist";
	public static String ERROR_INSUFFICIENT_FUNDS = "Insufficient Funds";
	
	public static String CustomerInfo(String name, String custNo, String acNo){
		return "Customer: " + name + " No: " + custNo + " AccountNo:" + acNo + "\n";
	}
	
	public static String WithdrawInfo(int value, int newBal){
		return "Deposit: " + Statistics.toPoundsAndPence(value) + " New Balance: " + Statistics.toPoundsAndPence(newBal) + "\n";
	}
	
	public static String DepositInfo(int value, int newBal){
		return "Deposit: " + Statistics.toPoundsAndPence(value) + " New Balance: " + Statistics.toPoundsAndPence(newBal) + "\n";
	}
}
