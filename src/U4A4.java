// Yegor Kuznetsov
//
// This program simulates a credit card company earning money. It tells how
// long it will take to pay off a debt, and how much the company will earn.

import java.util.Scanner;

public class U4A4
{
	private double balance;
	private int minimumPaymentPercent;
	private double apr;
	private double totalPaid;
	private int months;
	private double profit;

	public static void main(String[] args)
	{
		U4A4 u4a4 = new U4A4();
	}

	public U4A4()
	{
		totalPaid = 0;

		Scanner in = new Scanner(System.in);

		System.out.print("Enter credit card balance: ");
		balance = in.nextInt();

		System.out.print("Enter minimum payment (as % of balance): ");
		minimumPaymentPercent = in.nextInt();

		System.out.print("Enter annual percentage rate: ");
		apr = in.nextInt() / 100.0;

		System.out.println("\n# of months to pay off debt = " + getMonths(balance));
		System.out.printf("Profit for credit card company = $%.2f", profit);
	}

	private int getMonths(double bal)
	{
		double monthlyPay = bal * minimumPaymentPercent / 100.0;
		monthlyPay = (bal < 20) ? bal * (1 + apr / 12)
				: ((monthlyPay < 20) ? 20 : monthlyPay);
		totalPaid += monthlyPay;
		totalPaid -= (bal < 20) ? bal * (1 + apr / 12) - bal : 0;
		double newBalance = bal * (1 + apr / 12) - monthlyPay;

		months++;

		if (newBalance > 0)
		{
			getMonths(newBalance);
		}
		
		profit = totalPaid - balance;
		return months;
	}
}

/*
Enter credit card balance: 1200
Enter minimum payment (as % of balance): 4
Enter annual percentage rate: 18

# of months to pay off debt = 67
Profit for credit card company = $551.30
*/

/*
Enter credit card balance: 1200
Enter minimum payment (as % of balance): 2
Enter annual percentage rate: 18

# of months to pay off debt = 130
Profit for credit card company = $1462.08
*/

/*
Enter credit card balance: 1200
Enter minimum payment (as % of balance): 2
Enter annual percentage rate: 21

# of months to pay off debt = 193
Profit for credit card company = $2797.01
*/