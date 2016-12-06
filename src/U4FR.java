// I put each FR problem in a method.

public class U4FR
{
	public static void main(String[] args)
	{
		one(); // type the method here
	}

	private static void one()
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				String character;
				if (i == j)
					character = "" + 2 * (j + 1);
				else
					character = "-";
				System.out.print(character);
			}
			System.out.println();
		}
	}

	private static void two()
	{
		int pop = 89200000;
		for (int i = 1; pop < 120000000; i++)
		{
			pop = (int) (1.023 * pop);
			System.out.println("Year: " + (1990 + i) + ", Population: " + pop);
		}
	}

	private static void three(String grades)
	{
		int sum = 0;
		int i = 0;
		for (; i < grades.length(); i++)
		{
			String letter = grades.substring(i, i+1);
			if (letter.equals("A")) sum += 4;
			if (letter.equals("B")) sum += 3;
			if (letter.equals("C")) sum += 2;
			if (letter.equals("D")) sum += 1;
		}
		System.out.println("average gpa: " + ((double) sum / i));
	}

	private static void four()
	{
		System.out.println("Number    Factors\n------    -------");
		for (int i = 30; i <= 50; i++)
		{
			System.out.print(i + "        ");
			for (int j = 1; j < i; j++)
			{
				if (i % j == 0) System.out.print(j + ", ");
			}
			System.out.println(i);
		}
	}
}