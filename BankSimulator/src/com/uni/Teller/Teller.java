package com.uni.Teller;

import com.uni.queue.QueueItem;

public class Teller {

	public Teller(){
		
	}
	
	public void processQueueItem(QueueItem q){
		
		System.out.println("Processing: " + q.getTransaction().getChoice());
	}
}
