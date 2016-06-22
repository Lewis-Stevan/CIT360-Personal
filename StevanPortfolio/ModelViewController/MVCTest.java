public class MVCTest {
	public static void main(String[] args) {

		// Obtain pattern record based on the roll within the database
		Pattern model = retrivePatternFromDatabase();

		// Creates a view in order to write pattern details onto the console
		PatternView view = new PatternView();

		PatternController controller = new PatternController(model, view);

		controller.updateView();

		// Updates the pattern model data
		controller.setPatternName("Joe");

		controller.updateView();
	}

	private static Pattern retrivePatternFromDatabase() {
		Pattern pattern = new Pattern();
		pattern.setName("Peart");
		pattern.setRollNo("10");
		return pattern;
	}
}