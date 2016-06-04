package Topics;

import java.io.*;

public class DeserializeTest {

	public static void main(String[] args) {
		
		JSONExample e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("/CIT360/src/Topics/JSONExample.ser");
	         
	         //Deserializes the object
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (JSONExample) in.readObject();
	         in.close();
	         fileIn.close();
	      }
	      
	      catch(IOException i){
	         i.printStackTrace();
	         return;
	      }
	      
	      catch(ClassNotFoundException c){
	         System.out.println("JSONExample not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized JSONExample");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);

	}

}
