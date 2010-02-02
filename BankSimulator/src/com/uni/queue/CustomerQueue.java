package com.uni.queue;

import java.util.ArrayList;

public class CustomerQueue<QueueItem> extends ArrayList<QueueItem>{

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
