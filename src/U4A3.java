// Yegor Kuznetsov
//
// This program draws a salary schedule chart for teaches at schools. It
// uses the base salary, number of lanes, and number of steps per lane to
// generate the schedule.

import java.awt.Container;
import java.awt.Font;
import java.util.StringTokenizer;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class U4A3 extends JApplet
{
	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 16));

		String input = JOptionPane.showInputDialog(
				"Enter Base Salary(10000-50000),\nEnter Number of Lanes(3-6),\n"
						+ "Enter Number of Steps per Lane(10-20)\n\n"
						+ "(Separate the numbers with single spaces)");

		StringTokenizer tokenizer = new StringTokenizer(input);

		String token1 = tokenizer.nextToken();
		String token2 = tokenizer.nextToken();
		String token3 = tokenizer.nextToken();

		int int1 = Integer.parseInt(token1);
		int int2 = Integer.parseInt(token2);
		int int3 = Integer.parseInt(token3);

		out.setTabSize(6);

		out.append("                Salary Schedule\n\n    ");

		for (int i = 1; i <= int2; i++)
		{
			out.append("       " + i);
		}
		out.append("\n");

		int val1 = int1;
		int val2 = int1;

		for (int i = 1; i <= int3; i++)
		{
			if (i > 1)
			{
				val1 = (int) (val1 * 1.03);
				val2 = val1;
			}

			out.append("\n" + i + "\t");

			for (int j = 1; j <= int2; j++)
			{
				if (j > 1)
				{
					val2 = (int) (val2 * 1.09);
				}
				out.append("   " + val2);
			}
		}

		setSize(750, 500);
		Container container = getContentPane();
		container.add(out);
	}
}
