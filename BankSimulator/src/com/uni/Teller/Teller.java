package com.uni.Teller;

import com.main.account.Account;
import com.main.account.Transaction;
import com.uni.Logging.Log;
import com.uni.queue.QueueItem;

public class Teller {

	public Teller(){
		
	}
	
	public void processQueueItem(QueueItem q){
		Transaction t = q.getTransaction();
		Account ac;
		Integer value; //can't cast object to int
		
		switch(t.getChoice()){
		case WITHDRAW:
			Log.writeMessage("Teller processing withdraw transaction");
			ac = (Account)t.getSecondaryAux();
			value = (Integer)t.getPrimaryAux();
			ac.withDraw(value);
			break;
		case DEPOSIT:
			Log.writeMessage("Processing deposit Transaction");
			ac = (Account)t.getSecondaryAux();
			value = (Integer)t.getPrimaryAux();
			ac.deposit(value);
			break;
		case OPEN:
			Log.writeMessage("Processing open Transaction");
			break;
		case CLOSE:
			Log.writeMessage("Processing close Transaction");
			break;
		}		
	}
}
