// Yegor Kuznetsov
//
// This class has a parametric constructor that takes the number of the
// month, and sets "month" to it, and "days" to the number of days in the
// month.

public class Month
{
	int month;
	String days;

	public Month(int m)
	{
		month = m;
		setDays();
	}

	public String getDays()
	{
		return days;
	}

	public void setDays()
	{
		switch (month)
		{
			case 1:
				days = "31";
				break;
			case 2:
				days = "28 or 29";
				break;
			case 3:
				days = "31";
				break;
			case 4:
				days = "30";
				break;
			case 5:
				days = "31";
				break;
			case 6:
				days = "30";
				break;
			case 7:
				days = "31";
				break;
			case 8:
				days = "31";
				break;
			case 9:
				days = "30";
				break;
			case 10:
				days = "31";
				break;
			case 11:
				days = "30";
				break;
			case 12:
				days = "31";
				break;
		}
	}
}
