// Yegor Kuznetsov
//
// This class stores the sum and number of integers in a set. It has a
// method to add an integer, and a method to get the average of all the
// integers.

public class DataSet
{
	private int sum;
	private int count;

	public DataSet()
	{
		sum = 0;
		count = 0;
	}

	public DataSet(int s, int c)
	{
		sum = s;
		count = c;
	}

	public int getSum()
	{
		return sum;
	}

	public int getCount()
	{
		return count;
	}

	public void addValue(int x)
	{
		sum += x;
		count++;
	}

	public double average()
	{
		return (double) sum / count;
	}
}
