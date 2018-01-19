import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Michal Bodzek
 * 1. Create a JPanel.
 * 2. Assign a layout manager to it.
 * 3. Instantiate Swing controls and add them to the panel.
 * 4. Add panel to top-level-container JFrame calling setContentPane() method
 * 5. Set frame size and make it visible
 */
public class SimpleCalcGridBorder implements ActionListener {
	//Declare all components
	private JPanel windowContent;
	private JTextField displayField;
	private boolean calculating = true;
	private String operator = "=";
	private double result = 0;
	public void setDisplayValue(String value) {
		displayField.setText(value);
	}
	public String getDisplayValue() {
		return displayField.getText();
	}
	private JButton button0;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton buttonPoint;
	private JButton buttonEqual;
	private JButton buttonPlus;
	private JButton buttonMinus;
	private JButton buttonMultiply;
	private JButton buttonDivide;
	private JPanel panel;
	
	// Constructor creates components
	// adds them to the frame using GridLayout and BorderLayout
	public SimpleCalcGridBorder() {
		windowContent = new JPanel();
		// Set BorderLayout manager to that panel
		BorderLayout borderLayout = new BorderLayout();
		windowContent.setLayout(borderLayout);
		// Create a display field in North area of the window
		displayField = new JTextField(30);
		windowContent.add("North", displayField);
		// Creates buttons with adding labels in constructor of JButton
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPoint = new JButton(".");
		buttonEqual = new JButton("=");
		buttonPlus = new JButton("+");
		buttonMinus = new JButton("-");
		buttonMultiply = new JButton("*");
		buttonDivide = new JButton("/");
		// Create the panel with GridLayout with 12 buttons
		panel = new JPanel();
		GridLayout gridLayout = new GridLayout(4, 4);
		panel.setLayout(gridLayout);
		// Add window controls to the panel
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(buttonPlus);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(buttonMinus);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(buttonMultiply);
		panel.add(button0);
		panel.add(buttonPoint);
		panel.add(buttonEqual);
		panel.add(buttonDivide);
		// Add panel to the Center of the window
		windowContent.add("Center", panel);
		// Create frame and set it
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);
		// Set frame size to accommodate all controls and set it visible
		frame.pack();
		frame.setVisible(true);
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		buttonPoint.addActionListener(this);
		buttonEqual.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonDivide.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String dispFieldText = this.getDisplayValue();
		String clickedButtonLabel = clickedButton.getText();
		
		if ('0' <= clickedButtonLabel.charAt(0) && clickedButtonLabel.charAt(0) <= '9' || clickedButtonLabel.equals(".")) {
	      if (calculating) {
	    	  this.setDisplayValue(clickedButtonLabel);
	      }
	      else {
	    	  this.setDisplayValue(dispFieldText + clickedButtonLabel);
	      }
	      calculating = false;
	    } else {
	      if (calculating) {
	        if (clickedButtonLabel.equals("-")) {
	        	this.setDisplayValue(clickedButtonLabel);
	        	calculating = false;
	        } else
	          operator = clickedButtonLabel;
	      } else {
	        double x = Double.parseDouble(dispFieldText);
	        calculate(x);
	        operator = clickedButtonLabel;
	        calculating = true;
	      }
	    }
	}
	
	private void calculate(double n) {
	    if (operator.equals("+"))
	      result += n;
	    else if (operator.equals("-"))
	      result -= n;
	    else if (operator.equals("*"))
	      result *= n;
	    else if (operator.equals("/"))
	      result /= n;
	    else if (operator.equals("="))
	      result = n;
	    this.setDisplayValue("" + result);
	  }
	
	public static void main(String[] args) {
		//@SuppressWarnings("unused")
		SimpleCalcGridBorder calculator = new SimpleCalcGridBorder();

	}

}
