// Yegor Kuznetsov
//
// This is a subclass that extends Worker.
// It handles workers that get a salary.

public class SalariedWorker extends Worker
{
    private int hoursWorked;

    public SalariedWorker(String name, double hourlyWage, int hoursWorked)
    {
        super(name, hourlyWage);
        this.hoursWorked = hoursWorked;
    }

    public double Wage()
    {
        return computePay(40);
    }
}
