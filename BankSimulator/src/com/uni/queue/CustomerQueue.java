package com.uni.queue;

import java.util.ArrayList;

public class CustomerQueue<QueueItem> extends ArrayList<QueueItem>{

	//We need a queue number. Thing with array list is if you remove
	//1 then all the accounts get shifted left e.g. 1 becomes 0.
	//instead of super.add(QueueItem) we should do super.add(key, QueueItem)
	//where "key" is the customer number. yoooo
	private int lastCustomer = 0;
	
	public CustomerQueue(){
		super();
	}

	@Override
	public boolean add(QueueItem arg0) {
		return super.add(arg0);
	}
	
	@Override
	public String toString(){
		String retV = "";
		for(QueueItem qi:this){
			retV += qi.toString();
		}
		return retV;
	}
	
	public QueueItem getFirst() throws Exception{
		
		if(!this.isEmpty()){
			QueueItem q = this.remove(0);
			return q;
		}
		
		throw new Exception();
	}




	
}
