// Yegor Kuznetsov
//
//

public class Employee
{
	private String name;
	private double salary;

	public Employee()
	{
		name = "Hacker, Harry";
		salary = 55000;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		salary = salary * (1 + byPercent / 100);
	}

	public void bonus(int amount)
	{
		salary += amount;
	}
}
