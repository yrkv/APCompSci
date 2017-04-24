// Yegor Kuznetsov
//
// This is a driver class that creates a JFrame and draws some cars and trucks on it.
// I also made it so that they don't intersect.

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class U9A3 extends JFrame
{
    private ArrayList<Vehicle> list = new ArrayList<>();

    public static void main(String[] args)
    {
        U9A3 u9a3 = new U9A3();

        u9a3.setSize(500, 500);
        u9a3.setVisible(true);
        u9a3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public U9A3()
    {
        super("Unit 9 Assignment 3");

        getContentPane().setBackground(Color.YELLOW);

        outer: for (int i = 0; i < 10; i++) {
            Vehicle vehicle = (Math.random() > 0.5) ?
                    new Car((int) (Math.random() * 350) + 15, (int) (Math.random() * 390) + 50) :
                    new Truck((int) (Math.random() * 350) + 15, (int) (Math.random() * 390) + 50);

            for (Vehicle x: list)
                if (intersect(vehicle, x))
                {
                    i--;
                    continue outer;
                }

            list.add(vehicle);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        for (Vehicle x: list)
            x.draw(g);
    }

    private boolean intersect(Vehicle a, Vehicle b)
    {
        Rectangle r1 = new Rectangle(a.getInitX(), a.getInitY(), 125, 50);
        Rectangle r2 = new Rectangle(b.getInitX(), b.getInitY(), 125, 50);

        return r1.intersects(r2);
    }
}
