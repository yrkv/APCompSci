// Yegor Kuznetsov
//
// This class has a parametric constructor that takes the year, uses
// Guass's algorithm to get the day and month of Easter Sunday, and stores
// them in two instance fields.

public class EasterSunday
{
	private int month;
	private int day;

	public EasterSunday(int y)
	{
		int a = y % 19;
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		month = (h - m + r + 90) / 25;
		day = (h - m + r + month + 19) % 32;
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
