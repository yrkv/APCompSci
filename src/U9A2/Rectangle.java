// Yegor Kuznetsov
//
// This is the Rectangle class. It has a rendering method that draws several lines.
// It cannot be extended.

import java.awt.Graphics;

public final class Rectangle extends Line
{
    private int width;

    public Rectangle(int x, int y, int len, int wid)
    {
        super(x, y, len);
        width = wid;
    }


    public void draw(Graphics g)
    {
        for (int i = 0; i < width; i++)
        {
            super.draw(g);
            adjustY();
        }
    }
}
