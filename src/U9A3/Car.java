// Yegor Kuznetsov
//
// This is a class for handling a the rendering of a car on a JFrame.

import java.awt.Graphics;
import java.awt.Color;

public class Car extends Vehicle
{
    public Car(int x, int y)
    {
        super(x, y);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.drawRect(getInitX() + 20, getInitY(), 40, 20);
        g.drawRect(getInitX(), getInitY() + 20, 80, 20);
        g.drawOval(getInitX() + 10, getInitY() + 40, 10, 10);
        g.drawOval(getInitX() + 60, getInitY() + 40, 10, 10);
    }
}
