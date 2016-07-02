// Author: Steve lewis

import java.awt.event.ActionListener;
import javax.swing.*;

public class ViewMVC extends JFrame {

	// Multiply
	private JTextField jtf1 = new JTextField(10);
	private JLabel jl1 = new JLabel(" & ");
	private JTextField jtf2 = new JTextField(10);
	private JLabel jl2 = new JLabel(" = ");
	private JTextField jtf3 = new JTextField(10);

	private JButton jbAdd = new JButton("Addition");
	private JButton jbSub = new JButton("Subtraction");
	private JButton jbMult = new JButton("Multiplication");
	private JButton jbDiv = new JButton("Division");
	
	ViewMVC() {

		// Sets up the view
		JPanel calcPanel = new JPanel();

		// Exit on close - important
		// Also set the size of the GUI
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(425, 110);
		jtf3.setEditable(false);
		setTitle("Simple Calculator");
		setLocationRelativeTo(null);
		
		// Primary Panel
		calcPanel.add(jtf1);
		calcPanel.add(jl1);
		calcPanel.add(jtf2);
		calcPanel.add(jl2);
		calcPanel.add(jtf3);

		// Secondary Panel
		calcPanel.add(jbAdd);
		calcPanel.add(jbSub);
		calcPanel.add(jbMult);
		calcPanel.add(jbDiv);
		
		this.add(calcPanel);

	}

	// Get method for jtf1
	public double getInputOne() {

		return Double.parseDouble(jtf1.getText());
	}

	// Get method for jtf2
	public double getInputTwo() {

		return Double.parseDouble(jtf2.getText());
	}

	// Display the remainder found
	public void setSolution(double remainder) {

		jtf3.setText(Double.toString(remainder));
	}

	// Create our listener
	void calcListener(ActionListener listen4Button) {

		// Add the jbuttons to the listener
		jbAdd.addActionListener(listen4Button);
		jbSub.addActionListener(listen4Button);
		jbMult.addActionListener(listen4Button);
		jbDiv.addActionListener(listen4Button);
	}

	// If no input is provided let the user know
	void displayErrorMessage(String errorMessage) {

		// JOptionPane popup to notify user
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}