// Yegor Kuznetsov
//
// This is a driver class to show some inheritance stuff.
// It draws some rectangles by drawing lines by drawing points.
// It uses a JApplet to draw some green rectangles on a yellow background.

import javax.swing.JApplet;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class U9A2 extends JApplet
{
    public void init()
    {
        setSize(400, 400);
        getContentPane().setBackground(Color.YELLOW);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        Rectangle r1 = new Rectangle(25, 30, 10, 5);
        Rectangle r2 = new Rectangle(75, 100, 15, 3);
        Rectangle r3 = new Rectangle(50, 200, 8, 12);

        r1.draw(g);
        r2.draw(g);
        r3.draw(g);
    }
}
