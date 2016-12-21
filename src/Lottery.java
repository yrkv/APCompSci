// Yegor Kuznetsov
//
// This class is used by U5A2 to simulate a lottery, and check if a set of
// numbers wins anything.

public class Lottery
{
	private int[] numbers = new int[5];
	private int ball;

	public Lottery()
	{
		for (int i = 0; i < 5; i++)
		{
			int number = (int) (59 * Math.random() + 1);
			while (number == numbers[0] || number == numbers[1]
					|| number == numbers[2] || number == numbers[3]
					|| number == numbers[4])
			{
				number = (int) (59 * Math.random() + 1);
			}
			numbers[i] = number;
		}
		ball = (int) (35 * Math.random() + 1);
	}

	public int check(int[] nums, int pb)
	{
		int matches = 0;
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (nums[j] == numbers[i])
					matches++;
			}
		}

		switch (matches + 10 * (pb == ball ? 1 : 0))
		{
			case 15:
				return 1000000;
			case 5:
				return 500000;
			case 14:
				return 10000;
			case 4:
				return 100;
			case 13:
				return 100;
			case 3:
				return 7;
			case 12:
				return 7;
			case 11:
				return 4;
			case 10:
				return 4;
		}
		return 0;
	}

	public int getBall()
	{
		return ball;
	}

	public int[] getNumbers()
	{
		return numbers;
	}
}
