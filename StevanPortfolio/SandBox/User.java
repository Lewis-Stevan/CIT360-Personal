import java.util.*;
import java.security.*;

// Account holder or User
public class User {

	private String firstName;
	private String lastName;
	// User ID number
	private String uuid;
	// Encoded hash pin number of user
	private byte pinHash[];
	private ArrayList<Account> accounts;
	
	// Constructor for user
	public User(String firstName, String lastName, String pin, Bank theBank) {
		
		//User's Name
		this.firstName = firstName;
		this.lastName = lastName;
		
		// Store the pin's hash rather than original value for security reasons
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error, NoSuchAlgorithim Caught");
			e.printStackTrace();
			System.exit(1);
		}
		
		// Generate our own unique ID number for each user
		this.uuid = theBank.getNewUserUUID();
		
		// Empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		// Print Login message
		System.out.printf("New User %s, %s with ID %s created.\n", lastName, 
				firstName, this.uuid);
	}
	
	// Get the User ID number
	public String getUUID() {
		return this.uuid;
	}
	
	/**
	 * Add an account for the user.
	 * @anAcct	the account to add
	 */
	public void addAccount(Account anAcct) {
		this.accounts.add(anAcct);
	}
	
	// Get the number of accounts the user has
	public int numAccounts() {
		return this.accounts.size();
	}
	
	/**
	 * Get the balance of a particular account.
	 * @acctIdx	the index of the account to use
	 * @return	the balance of the account
	 */
	public double getAcctBalance(int acctIdx) {
		return this.accounts.get(acctIdx).getBalance();
	}
	
	/**
	 * Get the UUID of a particular account.
	 * @acctIdx	the index of the account to use
	 * @return	the UUID of the account
	 */
	public String getAcctUUID(int acctIdx) {
		return this.accounts.get(acctIdx).getUUID();
	}
	
	/**
	 * Print transaction history for a particular account.
	 * @acctIdx	the index of the account to use
	 */
	public void printAcctTransHistory(int acctIdx) {
		this.accounts.get(acctIdx).printTransHistory();
	}
	
	/**
	 * Add a transaction to a particular account.
	 * @acctIdx	the index of the account
	 * @amount	the amount of the transaction
	 * @memo	the memo of the transaction
	 */
	public void addAcctTransaction(int acctIdx, double amount, String memo) {
		this.accounts.get(acctIdx).addTransaction(amount, memo);
	}
	
	/**
	 * Check whether a given pin matches the true User pin
	 * @aPin	the pin to check
	 * @return	whether the pin is valid or not
	 */
	public boolean validatePin(String aPin) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return MessageDigest.isEqual(md.digest(aPin.getBytes()), 
					this.pinHash);
		} catch (Exception e) {
			System.err.println("error, caught exeption : " + e.getMessage());
			System.exit(1);
		}
		
		return false;
	}
	
	//Summary printed for user account
	public void printAccountsSummary() {
		
		System.out.printf("\n\n%s's accounts summary\n", this.firstName);
		for (int a = 0; a < this.accounts.size(); a++) {
			System.out.printf("%d) %s\n", a+1, 
					this.accounts.get(a).getSummaryLine());
		}
		System.out.println();
		
	}
}
