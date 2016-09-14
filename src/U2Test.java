import java.util.Scanner;

// Yegor Kuznetsov
//
//

public class U2Test
{
	public static void main(String[] args)
	{
		DataSet one = new DataSet();
		DataSet two = new DataSet(73, 8);
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Integer #1: ");
		int a = in.nextInt();
		
		System.out.print("Enter Integer #2: ");
		int b = in.nextInt();
		
		System.out.print("Enter Integer #3: ");
		int c = in.nextInt();
		
		System.out.print("Enter Integer #4: ");
		int d = in.nextInt();
		
		one.addValue(a);
		one.addValue(b);
		one.addValue(c);
		one.addValue(d);
		
		two.addValue(a);
		two.addValue(b);
		two.addValue(c);
		two.addValue(d);
		
		System.out.printf("\nDefault Constructor Average    = %2.1f", one.average());
		
		System.out.printf("\nParametric Constructor Average = %2.1f", two.average());
		
	}
}
