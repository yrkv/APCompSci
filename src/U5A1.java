// Yegor Kuznetsov
//
// This program calculates the correlation between two sets of data. It
// also displays the means of the arrays, and the standard deviations.

public class U5A1
{
	public static void main(String[] args)
	{
		U5A1 u5a1 = new U5A1();
	}

	public U5A1()
	{
		int[] apExam = {4, 5, 5, 5, 3, 2, 5, 4, 5, 4, 3, 4, 5, 4, 4, 5, 4};
		int[] grades = {5, 5, 5, 5, 4, 4, 5, 3, 5, 4, 4, 5, 5, 4, 4, 5, 4};

		System.out.printf("Mean of AP Exams = %.2f\n", mean(apExam));
		System.out.printf("Mean of Grades   = %.2f\n\n", mean(grades));

		System.out.printf("Standard Deviation of AP Exams = %.2f\n",
				standardDev(apExam));
		System.out.printf("Standard Deviation of Grades   = %.2f\n\n",
				standardDev(grades));

		System.out.printf("Correlation = %.2f", correlation(apExam, grades));
	}

	private double mean(int[] scores)
	{
		double sum = 0;
		for (int x : scores)
			sum += x;
		return sum / scores.length;
	}

	private double standardDev(int[] scores)
	{
		double mean = mean(scores);
		double sum = 0;
		for (int x : scores)
			sum += Math.pow((x - mean), 2);
		return Math.sqrt(sum / scores.length);
	}

	private double correlation(int[] a, int[] b)
	{
		double sum = 0;
		double mean_a = mean(a);
		double mean_b = mean(b);
		for (int i = 0; i < a.length; i++)
			sum += (a[i] - mean_a) * (b[i] - mean_b)
					/ ((a.length - 1) * standardDev(a) * standardDev(b));
		return sum;
	}
}
/*
Mean of AP Exams = 4.18
Mean of Grades   = 4.47

Standard Deviation of AP Exams = 0.86
Standard Deviation of Grades   = 0.61

Correlation = 0.67
*/