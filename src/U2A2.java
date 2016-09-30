// Yegor Kuznetsov
//
// This program is the driver class for the Cashier class. It constructs a
// Scanner object and uses that to input values to the Cashier class. Then,
// it prints out the change due.

import java.util.Scanner;

public class U2A2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Enter Amount Due: ");
		int due = (int) (in.nextDouble() * 100);

		System.out.print("Enter Amount Received: ");
		int received = (int) (in.nextDouble() * 100);

		Cashier cashier = new Cashier(due, received);

		System.out.println();

		System.out.printf("Dollars  = %d \n", cashier.getDollars());
		System.out.printf("Quarters = %d \n", cashier.getQuarters());
		System.out.printf("Dimes    = %d \n", cashier.getDimes());
		System.out.printf("Nickels  = %d \n", cashier.getNickels());
		System.out.printf("Pennies  = %d \n", cashier.getPennies());
	}
}

/*
Enter Amount Due: 41.35
Enter Amount Received: 50.00

Dollars  = 8 
Quarters = 2 
Dimes    = 1 
Nickels  = 1 
Pennies  = 0 
*/