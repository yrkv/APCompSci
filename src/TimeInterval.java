// Yegor Kuznetsov
//
// This program is the TimeInterval class. The parametric constructor takes
// the start and end of a time during which a worker worked, and the
// pay of the worker. The time is formatted in military format. It
// calculates the total number of minutes and hours that they worked on.
// The getPay method returns the total pay the worker should
// receive.

public class TimeInterval
{
	private int hours;
	private int minutes;
	private double pay;

	public TimeInterval(int start, int end, double p)
	{
		hours = (end - start) / 100;
		minutes = end - start - hours * 100 - 40;
		pay = p;
		setPay();
	}

	public int getHours()
	{
		return hours;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public double getPay()
	{
		return pay;
	}
	
	public void setPay()
	{
		pay = pay * hours + pay * minutes / 60;
	}
}
