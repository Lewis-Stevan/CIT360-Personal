import java.util.*;

public class Account {
	
	private String name;
	// Account ID number
	private String uuid;
	// Account holder
	private User holder;
	private ArrayList<Transaction> transactions;
	
	/**
	 * Create new Account
	 * @name	the name of the account
	 * @holder	the User object that holds this account
	 * @theBank	the bank that issues the account
	 */
	public Account(String name, User holder, Bank theBank) {
		
		// set the account name and holder
		this.name = name;
		this.holder = holder;
		
		// get next account UUID
		this.uuid = theBank.getNewAccountUUID();
		
		// init transactions
		this.transactions = new ArrayList<Transaction>();
		
	}
	
	// Account number obtained
	public String getUUID() {
		return this.uuid;
	}
	
	// Add transaction to the acccount
	public void addTransaction(double amount) {
		
		// Create new transaction and add it to the list
		Transaction newTrans = new Transaction(amount, this);
		this.transactions.add(newTrans);
		
	}
	
	/**
	 * Add a new transaction in this account.
	 * @amount	the amount transacted
	 * @memo	the transaction memo
	 */
	public void addTransaction(double amount, String memo) {
		
		// create new transaction and add it to the list
		Transaction newTrans = new Transaction(amount, memo, this);
		this.transactions.add(newTrans);
		
	}
	
	// Get balance of account by adding transactions
	public double getBalance() {
		double balance = 0;
		for (Transaction t : this.transactions) {
			balance += t.getAmount();
		}
		return balance;
	}
	
	// Summary of account info
	public String getSummaryLine() {
		
		// get the account's balance
		double balance = this.getBalance();
		
		if (balance >= 0) {
			return String.format("%s : $%.02f : %s", this.uuid, balance, 
					this.name);
		} else {
			return String.format("%s : $(%.02f) : %s", this.uuid, balance, 
					this.name);
		}
		
	}
	
	// Transaction history printed for account
	public void printTransHistory() {
		
		System.out.printf("\nTransaction history for account %s\n", this.uuid);
		for (int t = this.transactions.size()-1; t >= 0; t--) {
			System.out.println(this.transactions.get(t).getSummaryLine());
		}
		System.out.println();	
	}
}
