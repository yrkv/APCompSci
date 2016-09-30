// Yegor Kuznetsov
//
// This program tests the methods of the Employee class by raising the
// salary of an employee with percent raises and bonuses.

public class U1Test
{
	public static void main(String[] args)
	{
		Employee emp = new Employee();

		System.out.println(emp.getName() + "   " + emp.getSalary());

		emp.raiseSalary(4);
		System.out.println(emp.getSalary());

		emp.bonus(200);
		System.out.println(emp.getSalary());

		emp.raiseSalary(5.5);
		System.out.println(emp.getSalary());
	}
}

/* 
Hacker, Harry   55000.0
57200.0
57400.0
60557.0
*/