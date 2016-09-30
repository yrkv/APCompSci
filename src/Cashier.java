// Yegor Kuznetsov
//
// This is the Cashier class. It has a parametric constructor that takes
// change due and change received, and calculates the number of dollars,
// quarters, dimes, nickels and pennies that are due.

public class Cashier
{
	private int dollars;
	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;

	public Cashier(int due, int received)
	{
		int difference = received - due;

		dollars = difference / 100;
		difference -= dollars * 100;

		quarters = difference / 25;
		difference -= quarters * 25;

		dimes = difference / 10;
		difference -= dimes * 10;

		nickels = difference / 5;
		difference -= nickels * 5;

		pennies = difference;
	}

	public int getDollars()
	{
		return dollars;
	}

	public int getQuarters()
	{
		return quarters;
	}

	public int getDimes()
	{
		return dimes;
	}

	public int getNickels()
	{
		return nickels;
	}

	public int getPennies()
	{
		return pennies;
	}
}
