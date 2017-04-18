// Yegor Kuznetsov
//
// This is the Line class. It draws a line of
// points, and extends the Point class.

import java.awt.Graphics;

public class Line extends Point
{
    private int length;

    public Line(int x, int y, int len)
    {
        super(x, y);
        length = len;
    }

    public void draw(Graphics g)
    {
        for (int i = 0; i < length; i++)
        {
            super.draw(g);
            adjustX();
        }
        resetX(length);
    }
}
