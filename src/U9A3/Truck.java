// Yegor Kuznetsov
//
// This is a class for handling a the rendering of a truck on a JFrame.

import java.awt.Graphics;
import java.awt.Color;

public class Truck extends Vehicle
{
    public Truck(int x, int y)
    {
        super(x, y);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawRect(getInitX(), getInitY() + 20, 20, 20);
        g.drawRect(getInitX() + 25, getInitY(), 100, 40);
        g.drawOval(getInitX() + 5, getInitY() + 40, 10, 10);
        g.drawOval(getInitX() + 35, getInitY() + 40, 10, 10);
        g.drawOval(getInitX() + 45, getInitY() + 40, 10, 10);
        g.drawOval(getInitX() + 85, getInitY() + 40, 10, 10);
        g.drawOval(getInitX() + 95, getInitY() + 40, 10, 10);
    }
}
