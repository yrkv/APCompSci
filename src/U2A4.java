
// Yegor Kuznetsov
//
// This program uses the Scanner class to ask the user for a year, and
// outputs the day and month of Easter Sunday that year. It uses a Scanner
// object to get the name of the month from a text file.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class U2A4
{
	public static void main(String[] args)
	{
		U2A4 u2a4 = new U2A4();
	}

	public U2A4()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = in.nextInt();

		EasterSunday easterSunday = new EasterSunday(year);
		String name = getMonthName(easterSunday.getMonth());
		int day = easterSunday.getDay();

		System.out.printf("Easter Sunday is on %s%d", name, day);
	}

	public String getMonthName(int month)
	{
		Scanner in;
		try
		{
			in = new Scanner(new File("src/U2A4.txt"));
		} catch (IOException e)
		{
			throw new RuntimeException(e.toString());
		}
		String line = in.nextLine();
		String monthName = line.substring(9 * month - 9, 9 * month);
		return monthName;
	}
}

/*
Enter the year: 2016
Easter Sunday is on March    27

Enter the year: 2017
Easter Sunday is on April    16
*/
