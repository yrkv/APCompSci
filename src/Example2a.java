// Yegor Kuznetsov
//
// This program uses the Rectangle class

import java.awt.Rectangle;

public class Example2a
{

	public static void main(String[] args)
	{
		Rectangle x = new Rectangle(5, 8, 10, 20);

		x.setLocation(15, 18);

		boolean a = x.contains(12, 9);
		boolean b = x.contains(22, 13);
	}

}
