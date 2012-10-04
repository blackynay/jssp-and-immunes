package aia_g_jssp;

import java.util.*;

class HTDemo2 {
	public static void main(String args[]) {
		Hashtable balance = new Hashtable();
		String str;
		double bal;
		String rec="";
		for(int i=0;i<20;i++){
			rec=Integer.toString(i);
			balance.put(rec, new Double(i*2));
		}
		Integer[] a={1,3,2,6,4};

		// show all balances in hashtable
		Set set = balance.keySet(); // get set-view of keys
		// get iterator
		Iterator itr = set.iterator();
		//Collections.sort(balance.);
		while (itr.hasNext()) {
			str = (String) itr.next();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();
		// Deposit 1,000 into John Doe's account
		bal = ((Double) balance.get("4")).doubleValue();
		balance.put("4", new Double(bal + 1000));
		System.out.println("John Doe's new balance: " + balance.get("4"));
	}
}