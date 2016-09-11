// Yegor Kuznetsov
//
//

public class EasterSunday
{
	private int month;
	private int day;

	public EasterSunday(int y)
	{
		int temp;

		int a = y - (y / 19) * 19;
		int b = y / 100;
		int c = y - b * 100;
		int d = b / 4;
		int e = b - d * 4;
		int g = (8 * b + 13) / 25;
		temp = (19 * a + b - d - g + 15);
		int h = temp - (temp / 30) * 30;
		int j = c / 4;
		int k = c - j * 4;
		int m = (a + 11 * h) / 319;
		temp = (2 * e + 2 * j - k - h + m + 32);
		int r = temp - (temp / 7) * 7;
		month = (h - m + r + 90) / 25;
		temp = (h - m + r + month + 19);
		day = temp - (temp / 32) * 32;
	}

	public int getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}
}
