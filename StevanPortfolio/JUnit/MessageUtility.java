// This class will print the following message.

public class MessageUtility {

	private String message;

	// Message to be printed
	public MessageUtility(String message) {
		this.message = message;
	}

	// Prints message
	public String printMessage() {
		System.out.println(message);
		return message;
	}
}