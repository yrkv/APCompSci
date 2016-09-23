// Yegor Kuznetsov
//
// This program asks for the number of a month using an input box, and
// returns the name of the month and the number of days in it in the main
// applet window.

import javax.swing.JApplet;
import javax.swing.JTextArea;
import java.awt.Container;
import javax.swing.JOptionPane;

public class U3A3 extends JApplet
{
	String monthInt;
	String monthName;

	public void init()
	{
		monthInt = JOptionPane.showInputDialog("please enter month as a number: ");

		switch (monthInt)
		{
			case "1":
				monthName = "January";
				break;
			case "2":
				monthName = "February";
				break;
			case "3":
				monthName = "March";
				break;
			case "4":
				monthName = "April";
				break;
			case "5":
				monthName = "May";
				break;
			case "6":
				monthName = "June";
				break;
			case "7":
				monthName = "July";
				break;
			case "8":
				monthName = "August";
				break;
			case "9":
				monthName = "September";
				break;
			case "10":
				monthName = "October";
				break;
			case "11":
				monthName = "November";
				break;
			case "12":
				monthName = "December";
				break;
		}

		Month month = new Month(Integer.parseInt(monthInt));

		JTextArea out = new JTextArea();
		out.setText(
				"The month of " + monthName + "\nhas " + month.getDays() + " days.");

		Container container = getContentPane();
		container.add(out);
	}
}
