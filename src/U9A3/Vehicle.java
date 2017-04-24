// Yegor Kuznetsov
//
// This is a superclass for handling different types of vehicles, such as cars or trucks

import java.awt.Graphics;

public abstract class Vehicle
{
    private int initX;
    private int initY;

    public Vehicle(int x, int y)
    {
        initX = x;
        initY = y;
    }

    public int getInitX()
    {
        return initX;
    }

    public int getInitY()
    {
        return initY;
    }

    public abstract void draw(Graphics g);
}
