// Author: Steve Lewis
// This program uses the ControlMVC, ViewMVC, and ModelMVC. 
//Design based on calculator

public class MainMVC {

	public static void main(String[] args) {

		// Get the view
		ViewMVC ViewMVC = new ViewMVC();

		// Get the model
		ModelMVC ModelMVC = new ModelMVC();

		// Provide view and model to controler
		ControlMVC ControlMVC = new ControlMVC(ViewMVC, ModelMVC);

		// Make sure we can see the view
		ViewMVC.setVisible(true);

	}
}