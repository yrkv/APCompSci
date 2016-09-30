// Yegor Kuznetsov
//
// This program uses an infinite sequence to
// calculate the value of pi to 5 decimal spots.

public class U4A2
{
	private static final double PI = 3.14159;

	public static void main(String[] args)
	{
		U4A2 u4a2 = new U4A2();
	}

	public U4A2()
	{
		double currentPi = 0;
		int i = 0;

		do
		{
			currentPi += 4 * (1.0 / (2 * i + 1)) * Math.pow(-1, i);
			i++;
		} while (Math.round(currentPi * 100000) / 100000.0 != PI);

		System.out.printf("Value of pi = %.5f \n\n", currentPi);
		System.out.printf("Number of elements in the series = %d", i);
	}
}

/*
Value of pi = 3.14159 

Number of elements in the series = 130658
*/