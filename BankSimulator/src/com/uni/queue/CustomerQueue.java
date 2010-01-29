package com.uni.queue;

import java.util.ArrayList;

public class CustomerQueue<QueueItem> extends ArrayList<QueueItem>{

	public CustomerQueue(){
		super();
	}

	@Override
	public boolean add(QueueItem arg0) {
		// TODO Auto-generated method stub
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
