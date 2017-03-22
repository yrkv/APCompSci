// Yegor Kuznetsov
//
// This program is the driver for the DataSet_Old class. It creates two
// DataSets, adds four numbers that are input from the console. It then
// outputs the output of the "average" method for both sets.

import java.util.Scanner;

public class U2Test
{
	public static void main(String[] args)
	{
		DataSet_Old one = new DataSet_Old();
		DataSet_Old two = new DataSet_Old(73, 8);

		Scanner in = new Scanner(System.in);

		System.out.print("Enter Integer #1: ");
		int a = in.nextInt();

		System.out.print("Enter Integer #2: ");
		int b = in.nextInt();

		System.out.print("Enter Integer #3: ");
		int c = in.nextInt();

		System.out.print("Enter Integer #4: ");
		int d = in.nextInt();

		one.addValue(a);
		one.addValue(b);
		one.addValue(c);
		one.addValue(d);

		two.addValue(a);
		two.addValue(b);
		two.addValue(c);
		two.addValue(d);

		System.out.printf("\nDefault Constructor Average    = %.1f", one.average());
		System.out.printf("\nParametric Constructor Average = %.1f", two.average());

	}
}

/*
Enter Integer #1: 45
Enter Integer #2: 32
Enter Integer #3: 66
Enter Integer #4: 4

Default Constructor Average    = 36.8
Parametric Constructor Average = 18.3
*/