// Yegor Kuznetsov
//
// This program uses a dialog box to ask for the type of postage and the
// weight. It then uses the Postage class to calculate the price, and
// outputs it in a window.

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class U3Test extends Applet
{
	private Postage postage;

	public void init()
	{
		String data = JOptionPane.showInputDialog(
				"Enter Postage Type & ounces, separated by a space:");

		String type = data.substring(0, 1);
		double weight = Double.parseDouble(data.substring(2));

		postage = new Postage(type, weight);

		setBackground(Color.yellow);
		setSize(500, 100);
	}

	public void paint(Graphics g)
	{
		Font font = new Font("Monospaced", Font.BOLD, 32);
		g.setFont(font);

		g.drawString("Cost to mail this item =", 10, 30);

		String cost = String.format("$ %.2f", postage.calculate());

		g.drawString(cost, 40, 60);
	}
}