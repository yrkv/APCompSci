// Yegor Kuznetsov
//
//

import java.awt.Container;
import java.awt.Font;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class U4Test extends JApplet
{
	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.PLAIN, 16));
		
		String input = JOptionPane.showInputDialog("Enter Base Number: ");
		long baseNumber = Long.parseLong(input);
		
		
		long startTime = System.currentTimeMillis();
		long n;
		if (baseNumber % 2 == 0)
			n = baseNumber + 1;
		else
			n = baseNumber;
		
		while (!isPrime(n))
		{
			n += 2;
		}
		
		long time = System.currentTimeMillis() - startTime;
		
		out.append("Results of the Prime Number Search\n\n");
		
		out.append("Base Number = " + baseNumber);
		
		out.append("\n\nPrime Number = " + n);
		
		out.append("Elapsed Time = " + time + " milliseconds");
		
		setSize(750, 500);
		Container container = getContentPane();
		container.add(out);
	}
	
	private boolean isPrime(long n)
	{
		return true; // write your own. I want the EC
	}
}
