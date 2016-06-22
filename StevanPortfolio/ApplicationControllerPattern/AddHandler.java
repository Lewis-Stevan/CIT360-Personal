import java.util.ArrayList;

import javax.swing.*;

public class AddHandler<CalculatorActivity> implements Handler {
	private double value1;
	private double value2;
	private double result;
	private String resultString;

	public void handleIt(Object... parameters) {
		// Object is assigned activity
		CalculatorActivity activity = (CalculatorActivity) parameters[0];

		// Declares Textviews as it passes from calculator
		TableView txtInput = (TableView) parameters[1];
		TableView txtSolution = (TableView) parameters[2];

		value1 = Double.parseDouble(txtInput.getText().toString());
		value2 = Double.parseDouble(txtInput.getText().toString());

		result = value1 + value2;

		resultString = Double.toString(result);

		txtSolution.setText(resultString);

		txtInput.setText("");
	}
}