// Yegor Kuznetsov
//
// This program will draw a Rectangle object on an Applet

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.applet.Applet;

public class Example3 extends Applet
{
	public void init() {
		setBackground(Color.yellow);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(5, 8, 10, 20);
	}
}
