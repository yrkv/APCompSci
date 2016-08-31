// Yegor Kuznetsov
//
// This program will print the data for three rectangles, one, two, and
// three, and the intersection of one and two, and the
// intersection of one and three

import java.awt.Rectangle;

public class U1A2a
{
	public static void main(String[] args)
	{
		Rectangle one = new Rectangle(5, 10, 20, 30);
		Rectangle two = new Rectangle(10, 25, 35, 15);
		Rectangle three = new Rectangle(20, 30, 10, 25);

		System.out.println(one);
		System.out.println(two);
		System.out.println(three + "\n");

		Rectangle four = one.intersection(two);
		Rectangle five = one.intersection(three);

		System.out.println(four);
		System.out.println(five);
	}
}

/*

java.awt.Rectangle[x=5,y=10,width=20,height=30]
java.awt.Rectangle[x=10,y=25,width=35,height=15]
java.awt.Rectangle[x=20,y=30,width=10,height=25]

java.awt.Rectangle[x=10,y=25,width=15,height=15]
java.awt.Rectangle[x=20,y=30,width=5,height=10]


*/