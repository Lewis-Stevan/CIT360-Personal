import java.util.ArrayList;
import java.util.Random;


public class Bank {

	private String name;
	private ArrayList<User> users;
	private ArrayList<Account> accounts;
	
	// Bank object with users and accounts
	public Bank(String name) {
		this.name = name;
		
		// init users and accounts
		users = new ArrayList<User>();
		accounts = new ArrayList<Account>();
	}
	
	// User ID generated
	public String getNewUserUUID() {
		String uuid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique;

		// Loop till a unique ID is created
		do {
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// Check to make sure it's unique
			nonUnique = false;
			for (User u : this.users) {
				if (uuid.compareTo(u.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
	}
	
	// Generate new unique user account ID
	public String getNewAccountUUID() {
		
		String uuid;
		Random rng = new Random();
		int len = 10;
		boolean nonUnique = false;
		
		// Loop till a unique ID is created
		do {
			uuid = "";
			for (int c = 0; c < len; c++) {
				uuid += ((Integer)rng.nextInt(10)).toString();
			}
			
			// Check to make sure it's unique
			for (Account a : this.accounts) {
				if (uuid.compareTo(a.getUUID()) == 0) {
					nonUnique = true;
					break;
				}
			}
			
		} while (nonUnique);
		
		return uuid;
				
	}

	/**
	 * Create a new user of the bank.
	 * @firstName	the user's first name
	 * @lastName	the user's last name
	 * @pin			the user's pin
	 * @return		the new User object
	 */
	public User addUser(String firstName, String lastName, String pin) {
		
		// create a new User object and add it to our list
		User newUser = new User(firstName, lastName, pin, this);
		this.users.add(newUser);
		
		// create a savings account for the user and add it to our list
		Account newAccount = new Account("Savings", newUser, this);
		newUser.addAccount(newAccount);
		this.accounts.add(newAccount);
		
		return newUser;
		
	}
	
	// Add existing account to a user
	public void addAccount(Account newAccount) {
		this.accounts.add(newAccount);
	}
	
	/**
	 * Get the User object associated with a particular userID and pin, if they are valid.
	 * @userID	the user UUID to log in
	 * @pin		the associate pin of the user
	 * @return	the User object
	 */
	public User userLogin(String userID, String pin) {
		
		// Search through list of users
		for (User u : this.users) {
			
			// If user and the pin is correct, return User object
			if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
				return u;
			}
		}
		
		// No user or pin found return null
		return null;
		
	}
	
	// Get the name of the bank
	public String getName() {
		return this.name;
	}

}