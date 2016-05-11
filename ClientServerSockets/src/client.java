import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// Sockets are required for communication between a client and a server.
		// A Socket is an interface which enables the client and server to communicate and pass on information from one another
		// Two types of sockets: 1.Simple Socket/Socket 2.Server Socket
			// 1.Simple Socket or Socket: implements one side of a two-way connection between your Java program and another program on the network.
			// 2.Server Socket: implements a socket that servers can use to listen for and accept connections to clients
		
		
		// Declare the variable
		int number,tempint;
		
		// Accepts number from the user
		Scanner sc = new Scanner(System.in);
		
		// First step is create a socket object, need to specify two parameters, IP address
		// ( use localhost since server and client are running on the same machine) and port number
		Socket s = new Socket("localhost",1234);
		
		// Need to allow socket to accept information to and from the server
		Scanner sc1 = new Scanner(s.getInputStream());
		
		// Need to accept information from the user
		System.out.println("Enter any number:");
		
		// Scanner needs to accept the number
		number = sc.nextInt();
		
		
		// Passes the number onto the socket
		PrintStream p = new PrintStream(s.getOutputStream());
		p.println(number);
		
		// Needed to accept the result from the server
		tempint = sc1.nextInt();
		
		// Print out the tempint variable, which will be the result from the server
		System.out.println(tempint);
		
	}

}
