package Topics;

import java.io.*;
/*
 * Object serialization is where an object is represented in a sequence of  bytes 
 * that includes the object's data as well as information about the object's type and the types of data
 * stored in the object
 */
public class SerializeTest {

	//Serialize an object
	public static void main(String[] args) {
		
		JSONExample e = new JSONExample();
		e.name = "Steve Lewis";
		e.address = "23 N. Shore";
		
		try {
			FileOutputStream fileOut = new FileOutputStream("/CIT360/src/Topics/JSONExample.ser");
			
			//ObjectOutputStream class is used to serialize an object
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
	        out.writeObject(e);
	        out.close();
	        fileOut.close();
	        System.out.printf("Serialized data is saved in /CIT360/src/Topics/JSONExample.ser");
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}

	}

}
