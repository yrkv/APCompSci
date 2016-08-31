// Yegor Kuznetsov
//
// This program is an applet that draws a yellow background, with 2 blue
// rectangles. The intersection of the 2 blue rectangles is colored in red.

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.applet.Applet;

public class U1A2b extends Applet
{
	public void init()
	{
		setBackground(Color.yellow);
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.blue);

		Rectangle one = new Rectangle(5, 10, 50, 80);
		Rectangle two = new Rectangle(20, 50, 65, 55);
		Rectangle three = one.intersection(two);

		int x1 = (int) one.getX();
		int y1 = (int) one.getY();
		int width1 = (int) one.getWidth();
		int height1 = (int) one.getHeight();

		int x2 = (int) two.getX();
		int y2 = (int) two.getY();
		int width2 = (int) two.getWidth();
		int height2 = (int) two.getHeight();

		int x3 = (int) three.getX();
		int y3 = (int) three.getY();
		int width3 = (int) three.getWidth();
		int height3 = (int) three.getHeight();

		g.drawRect(x1, y1, width1, height1);
		g.drawRect(x2, y2, width2, height2);

		g.setColor(Color.red);

		g.fillRect(x3, y3, width3, height3);
	}
}
