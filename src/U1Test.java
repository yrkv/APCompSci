// Yegor Kuznetsov
//
//

public class U1Test
{
	public static void main(String[] args)
	{
		Employee emp = new Employee();
		
		System.out.println(emp.getName() + "\n\n\n");
		System.out.println(emp.getSalary());
		
		emp.raiseSalary(4);
		System.out.println(emp.getSalary());
		
	}
}
