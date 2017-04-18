// Yegor Kuznetsov
//
// This class represents a point. It is used to draw
// points, and has methods to manipulate location.

import java.awt.Graphics;
import java.awt.Color;

public class Point
{
    private int x, y;
    private static final int adjust = 10;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.drawString("*", x, y);
    }

    public void adjustX()
    {
        x += adjust;
    }

    public void resetX(int len)
    {
        x -= adjust * len;
    }

    public void adjustY()
    {
        y += adjust;
    }
}
