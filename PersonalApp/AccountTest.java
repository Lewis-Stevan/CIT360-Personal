import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {

	public static void main(String[] args) {
		Account myAccount = new Account(0.0);
		myAccount.deposit(500.00);
		System.out.println("Current balance is " + myAccount.getBalance());
		myAccount.withdraw(100.00);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
    // Class Invariant: balance >= 0.0
    private double balance = 0.0;

    /**
     * Create a new bank account object, with some initial balance.
     * 
     * @param amount the amount to initially deposit
     * Pre-condition: initialBalance >= 0.0
     */
    public Account ( double Balance ) {
        if ( initialBalance < 0.0 )
            throw new IllegalArgumentException( "Initial balance ("
                    + initialBalance + ") must be >= 0" );

        balance = initialBalance;
        assert balance >= 0.0 : "invariant violation: balance = " + balance;
    }

    //Amount to deposit
    public void deposit ( double amount )
    {
        if ( amount < 0.0 )
            throw new IllegalArgumentException( "Deposit amount (" + amount
                    + ") must be >= 0" );
        double newBalance = balance + amount;

        assert newBalance >= balance : "post-condition violation: new balance "
                + "(" + newBalance + ") < current balance (" + balance + ")";

        balance = newBalance;

        assert balance >= 0.0 : "invariant violation: balance = " + balance;
    }

    // Amount to withdraw
    public void withdraw( double amount )
    {
        if ( amount < 0.0 )
            throw new IllegalArgumentException( "Withdraw amount (" + amount
                    + ") must be >= 0" );

        if ( amount > balance )
            throw new IllegalArgumentException( "Withdraw amount (" + amount
                    + ") must be <= current balance (" + balance + ")" );
        balance -= amount;

        assert balance >= 0.0 : "invariant violation: balance = " + balance;
    }

    // Precondition amount to deposit
    public double getBalance ()
    {
        calculateInterest();

        assert balance >= 0.0 : "invariant violation: balance = " + balance;

        return balance;
    }

    /**
     * Post-condition: new balance >= old balance
     */
    private void calculateInterest ()
    {
        double newBalance = balance * .05;

        assert newBalance >= balance : "post-condition violation: new balance "
                + "(" + newBalance + ") < current balance (" + balance + ")";

        balance = newBalance;

        assert balance >= 0.0 : "post-condition violation: balance = " + balance;
    	}
	}
}
