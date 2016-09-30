// Yegor Kuznetsov
//
// This program is a driver for the TimeInterval class. It asks for the
// starting time, finishing time, and pay of a worker. It then prints the
// Minutes, hours, and total pay the worker should receive.

import java.util.Scanner;

public class U2A3
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter the starting time: ");
		int startTime = in.nextInt();

		System.out.print("Please enter the finishing time: ");
		int endTime = in.nextInt();

		System.out.print("Please enter rate of pay: ");
		double pay = in.nextDouble();

		TimeInterval interval = new TimeInterval(startTime, endTime, pay);

		int h = interval.getHours();
		int m = interval.getMinutes();
		double p = interval.getPay();

		System.out.println();
		System.out.printf("Time on Task = %d hours %d minutes", h, m);
		System.out.println("\n");
		System.out.printf("Pay = $%2.2f", p);

	}
}

/*
Please enter the starting time: 0930
Please enter the finishing time: 1700
Please enter rate of pay: 12.75

Time on Task = 7 hours 30 minutes

Pay = $95.63
*/