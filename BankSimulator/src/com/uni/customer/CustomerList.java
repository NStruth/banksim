package com.uni.customer;

import java.util.ArrayList;

import com.uni.Logging.Log;

public class CustomerList extends ArrayList<Customer> {

	@Override
	public boolean add(Customer e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}

	public void print()
	{
		for(Customer c: this){
			Log.writeMessage(c.toString()); 
		}
	}
	
}
