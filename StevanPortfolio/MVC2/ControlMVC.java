// Author: Steve Lewis

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ControlMVC {

	private ViewMVC ViewMVC;
	private ModelMVC ModelMVC;

	public ControlMVC(ViewMVC ViewMVC, ModelMVC ClacModel) {
		
		this.ViewMVC = ViewMVC;
		this.ModelMVC = ClacModel;

		// If a event or button is pressed and captured by the view let the controller know
		this.ViewMVC.calcListener(new ProcessListener());
	}

	class ProcessListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			double n1, n2, remainder = 0;

			// Get Placeholder button that was pressed
			JButton pressed = (JButton) (e.getSource());

			// Reach into Placeholder button and pull text
			String text = pressed.getText();

			// Check to see which column button was pressed
			// Get input from view
			// Push to model for processing
			// Gather returned processing from model
			// Push to view
			if (text.equals("Addition")) {

				try {

					n1 = ViewMVC.getInputOne();
					n2 = ViewMVC.getInputTwo();

					remainder = ModelMVC.addition(n1, n2);

					ViewMVC.setSolution(remainder);
				}

				catch (NumberFormatException ex) {

					System.out.println(ex);

					ViewMVC.displayErrorMessage("You Need to Enter 2 Integers");
				}
			} else if (text.equals("Subtraction")) {

				try {

					n1 = ViewMVC.getInputOne();
					n2 = ViewMVC.getInputTwo();

					remainder = ModelMVC.subtract(n1, n2);

					ViewMVC.setSolution(remainder);
				}

				catch (NumberFormatException ex) {

					System.out.println(ex);

					ViewMVC.displayErrorMessage("You Need to Enter 2 Integers");
				}
			} else if (text.equals("Multiplication")) {

				try {

					n1 = ViewMVC.getInputOne();
					n2 = ViewMVC.getInputTwo();

					remainder = ModelMVC.multiply(n1, n2);

					ViewMVC.setSolution(remainder);
				}

				catch (NumberFormatException ex) {

					System.out.println(ex);

					ViewMVC.displayErrorMessage("You Need to Enter 2 Integers");
				}
			} else if (text.equals("Division")) {

				try {

					n1 = ViewMVC.getInputOne();
					n2 = ViewMVC.getInputTwo();

					remainder = ModelMVC.division(n1, n2);

					ViewMVC.setSolution(remainder);
				}

				catch (NumberFormatException ex) {

					System.out.println(ex);

					ViewMVC.displayErrorMessage("You Need to Enter 2 Integers");
				}
			}
			else {
				// Do nothing
			}
		}
	}
}