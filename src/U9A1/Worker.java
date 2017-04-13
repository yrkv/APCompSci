// Yegor Kuznetsov
//
// This is a superclass for workers that stores the name and hourly wage.
// It has a method to compute the pay.

public class Worker
{
    private String name;
    private double hourlyWage;

    public Worker(String name, double hourlyWage)
    {
        this.name = name;
        this.hourlyWage = hourlyWage;
    }

    public double computePay(int hours)
    {
        return hourlyWage * hours;
    }

    public String getName()
    {
        return name.split(" ")[1] + ", " + name.split(" ")[0].charAt(0) + ".";
    }
}
