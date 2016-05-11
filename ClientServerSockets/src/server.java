import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Declare variables
		int number,tempint;
		
		
		// Need a server socket to communicate with the client, same port number on client class
		ServerSocket s1 = new ServerSocket(1234); 
		
		// Create a simple socket, accept incoming request from the client
		Socket ss = s1.accept();
		
		// Create Scanner object, and accepts the number the client wants to pass
		Scanner sc = new Scanner(ss.getInputStream());
		number = sc.nextInt();
		
		// Defines what the server will do with the number taken from the client
		tempint = number*2;
		
		// Result is passed back to the client
		PrintStream p = new PrintStream(ss.getOutputStream());
		p.println(tempint);
		
		// First run the server class than the client class
		
		
		
	}

}
