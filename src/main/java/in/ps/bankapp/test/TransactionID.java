package in.ps.bankapp.test;

import java.util.Random;

public class TransactionID {
	public static long generateTransactionId() {
		Random rd=new Random();
		long value=rd.nextLong();
		if(value<0) {
			value=value*-1;
		}
		return value;
	}
}
