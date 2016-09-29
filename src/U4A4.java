// Yegor Kuznetsov
//
//

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
		System.out.printf("Profit for credit card company = $%.2f\n", profit);
	}

	public int getMonths(double bal)
	{
		double monthlyPay = bal * minimumPaymentPercent / 100.0;
		monthlyPay = (bal < 20) ? bal * (1 + apr / 12)
				: ((monthlyPay < 20) ? 20 : monthlyPay);
		if (bal < 20)
			totalPaid = totalPaid - bal * (1 + apr / 12) + bal;
		totalPaid += monthlyPay;
		double newBalance = bal * (1 + apr / 12) - monthlyPay;
		profit = totalPaid - balance;

		months++;

		if (newBalance > 0)
		{
			getMonths(newBalance);
		}

		return months;
	}
}
