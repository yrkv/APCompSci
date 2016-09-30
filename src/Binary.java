// Yegor Kuznetsov
//
// This class is used by U4A1 to convert a base 2 number to a base 10
// number. It doesn't do anything except for that.

public class Binary
{
	private String number;

	public Binary(String n)
	{
		number = n;
	}

	public int convert()
	{
		int out = 0;
		String numberCopy = number;
		while (numberCopy.length() > 0)
		{
			out += Integer.parseInt(numberCopy.substring(0, 1))
					* Math.pow(2, numberCopy.length() - 1);
			numberCopy = numberCopy.substring(1);
		}
		return out;
	}
}
