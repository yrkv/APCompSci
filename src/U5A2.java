// Yegor Kuznetsov
//
// This program simulates a lottery with 5 numbers and a power ball. If
// someone wins over $10000, it displays their numbers. It also displays
// how many people received some of the lesser rewards.

public class U5A2
{
	public static void main(String[] args)
	{
		Lottery lottery = new Lottery();

		int[] n = lottery.getNumbers();

		System.out.printf("This Week's Numbers Are:\n%d  %d  %d  %d  %d  %d\n\n",
				n[0], n[1], n[2], n[3], n[4], lottery.getBall());

		int[] wins = new int[6];
		for (int i = 1; i <= 1000000; i++)
		{

			int[] numbers = new int[5];
			for (int j = 0; j < 5; j++)
			{
				int number = (int) (59 * Math.random() + 1);
				while (number == numbers[0] || number == numbers[1]
						|| number == numbers[2] || number == numbers[3]
						|| number == numbers[4])
				{
					number = (int) (59 * Math.random() + 1);
				}
				numbers[j] = number;
			}
			int ball = (int) (35 * Math.random() + 1);

			int money = lottery.check(numbers, ball);

			if (money >= 10000)
				System.out.printf("Player #%d wins: $%d\n%d  %d  %d  %d  %d  %d\n\n",
						i, money, numbers[0], numbers[1], numbers[2], numbers[3],
						numbers[4], ball);

			if (money == 4)
				wins[0]++;
			if (money == 7)
				wins[1]++;
			if (money == 100)
				wins[2]++;
			if (money == 10000)
				wins[3]++;
			if (money == 500000)
				wins[4]++;
			if (money == 1000000)
				wins[5]++;
		}

		System.out.printf("$4 Winners:                %d\n", wins[0]);
		System.out.printf("$7 Winners:                %d\n", wins[1]);
		System.out.printf("$100 Winners:              %d\n", wins[2]);
		System.out.printf("$10000 Winners:            %d\n", wins[3]);
		System.out.printf("$500000 Winners:           %d\n", wins[4]);
		System.out.printf("$1000000 Winners:          %d\n", wins[5]);
	}
}
/*
This Week's Numbers Are:
42  45  48  3  21  26

Player #451244 wins: $1000000
42  45  48  3  21  26

$4 Winners:                27233
$7 Winners:                4253
$100 Winners:              120
$10000 Winners:            0
$500000 Winners:           0
$1000000 Winners:          1
*/
