package Topics;

import java.util.*;

public class JCollections {

	public static void main(String[] args) {
		// This represents Java Collections: (Map, List, Set, Tree) Addition and Removal Using Iterators

		ArrayList<String> test = new ArrayList<String>();
		
		// Elements are added as such to the array list
		test.add("John");
		test.add("Bob");
		test.add("Margaret");
		test.add("Are the coolest");
		
		// Displays the array list elements
		System.out.println("Currently the array list contains: " + test);
		
		// Add element at the given index
		test.add(0, "John");
		test.add(1, "Jill");
		
		// Remove Elements from array list
		test.remove("John");
		test.remove("Bob");
		test.remove("Margaret");
		
		// Prints a new line, makes a space in between the output
		System.out.println("");
		
		// Prints current array list after using remove
		System.out.println("Now that Current list is: " + test);
		
	}
}
