import java.util.Date;


public class Transaction {

	private double amount;
	private Date timestamp;
	// Description of the transaction
	private String memo;
	// The account where the transaction was performed
	private Account inAccount;
	
	/**
	 * Create a new transaction.
	 * @amount		the dollar amount transacted
	 * @inAccount	the account the transaction belongs to
	 */
	public Transaction(double amount, Account inAccount) {
		this.amount = amount;
		this.inAccount = inAccount;
		this.timestamp = new Date();
		this.memo = "";
		
	}
	
	/**
	 * Created a new transaction with a memo.
	 * @amount		the dollar amount transacted
	 * @memo		the memo for the transaction
	 * @inAccount	the account the transaction belongs to
	 */
	public Transaction(double amount, String memo, Account inAccount) {
		
		// call the single-arg constructor first
		this(amount, inAccount);
		this.memo = memo;
	}
	
	// Transaction amount obtained
	public double getAmount() {
		return this.amount;
	}
	
	// String summarizes the transaction
	public String getSummaryLine() {
		
		if (this.amount >= 0) {
			return String.format("%s, $%.02f : %s", 
					this.timestamp.toString(), this.amount, this.memo);
		} else {
			return String.format("%s, $(%.02f) : %s", 
					this.timestamp.toString(), -this.amount, this.memo);
		}
	}
}
