// Yegor Kuznetsov
//
// This program uses the JOptionPane class to input a list of binary
// values. It then convert them to base 10, and displays the numbers and
// some statistics,

import java.awt.Container;
import java.awt.Font;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class U4A1 extends JApplet
{
	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 32));

		out.append("Results of U4A1\n\n");

		String number = JOptionPane.showInputDialog("Enter Binary Number:");
		Binary binary;
		int i = 0;
		int total = 0;
		while (!number.equals("-1"))
		{
			i++;
			binary = new Binary(number);
			total += binary.convert();

			out.setTabSize(10 - number.length());

			out.append("Number " + i + ":  " + number + " =\t" + binary.convert()
					+ "\n");

			number = JOptionPane.showInputDialog("Enter Binary Number:");
		}

		String mean = String.format("%.2f", (double) total / i);

		out.append("\nNumber of Numbers = " + i);
		out.append("\nAccumulated Value = " + total);
		out.append("\nMean              = " + mean);

		setSize(550, 354 + i * 32);

		Container container = getContentPane();
		container.add(out);
	}
}
