// Yegor Kuznetsov
//
// This is a subclass that extends Worker.
// It handles workers that get paid hourly.

public class HourlyWorker extends Worker
{
    private int hoursWorked;

    public HourlyWorker(String name, double hourlyWage, int hoursWorked)
    {
        super(name, hourlyWage);
        this.hoursWorked = hoursWorked;
    }

    public double Wage()
    {
        return computePay(hoursWorked) + computePay((hoursWorked > 40) ? hoursWorked - 40 : 0) / 2;
    }
}
