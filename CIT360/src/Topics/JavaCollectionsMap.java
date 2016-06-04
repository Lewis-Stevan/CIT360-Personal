package Topics;

import java.util.*;


public class JavaCollectionsMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creation of hash map
		HashMap<String, Double> hm = new HashMap<String, Double>();
		
		//Elements added to the map, example of different accounts for bank
		hm.put("Steve", new Double(2157));
		hm.put("Joe", new Double(567));
		hm.put("Jill", new Double(231));
		hm.put("Bob", new Double(427));
		
		//Get a set of the entries
		Set<?> set = hm.entrySet();
		
		//Get an iterator
		Iterator<?> i = set.iterator();
		
		//Display elements
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		
		// Deposit 500 into steve's account
		double balance = hm.get("Steve").doubleValue();
		hm.put("Steve", new Double(balance + 500));
		
	    System.out.println("Steve's new balance: " +
	    hm.get("Steve"));
	}

}
