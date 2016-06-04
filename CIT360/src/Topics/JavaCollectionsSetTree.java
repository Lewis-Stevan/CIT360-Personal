package Topics;

import java.util.*;

public class JavaCollectionsSetTree {

	public static void main(String[] args) {
		
		//Created a list set
		int count[] = {34, 22,10,60,30,22};
	     Set<Integer> set = new HashSet<Integer>();
	     try{
	        for(int i = 0; i<5; i++){
	           set.add(count[i]);
	        }
	        //Prints out the set list
	        System.out.println(set);
	  
	        //The set is sorted from lowest to highest using a tree
	        TreeSet sortedSet = new TreeSet<Integer>(set);
	        System.out.println("The sorted list is:");
	        System.out.println(sortedSet);

	        //Prints out the first element in the sorted tree set list
	        System.out.println("The First element of the set is: "+
	                          (Integer)sortedSet.first());
	        
	        //Prints out the last element in the sorted tree set list
	        System.out.println("The last element of the set is: "+
	                        (Integer)sortedSet.last());
	     }
	     catch(Exception e){}
	}

}
