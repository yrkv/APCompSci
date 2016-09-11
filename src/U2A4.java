
// Yegor Kuznetsov
//
//

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class U2A4
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = in.nextInt();

		EasterSunday easterSunday = new EasterSunday(year);

		U2A4 u2a4 = new U2A4();

		String name = u2a4.getMonthName(easterSunday.getMonth());
		int day = easterSunday.getDay();

		System.out.printf("Easter Sunday is on %s%d", name, day);
	} 

	public U2A4()
	{

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
