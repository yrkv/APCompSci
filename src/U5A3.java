// Yegor Kuznetsov
//
//

import javax.swing.JApplet;

public class U5A3 extends JApplet
{
	private int length;
	private int[] array1;
	private int[] array2;
	
	public void init()
	{
		array2 = new int[30];
		for (int i = 0; i < 30; i++)
		{
			array2[i] = (int) (256 * Math.random());
		}
		
		fillArray();
		
		for (int i = 0; i < 30; i++)
		{
			int j = 0;
			boolean found = false;
			
			while (j < length && !found)
			{
				if (array2[i] > array1[j])
					j++;
				else
					found = true;
			}
			insert(array2[i], j);
		}
		
		System.out.print("{");
		for (int i = 0; i < length; i++)
		{
			System.out.print(array1[i] + ",");
		}
		System.out.println("}");
	}
	
	public void fillArray() 
	{
		length = (int) (51 * Math.random() + 50);
		System.out.println(length);
		array1 = new int[length];
		System.out.print("{");
		for (int i = 0; i < 50; i++)
		{
			array1[i] = (int) (5 * (Math.random() + i));
			System.out.print(array1[i] + ",");
		}
		System.out.println("}");
	}
	
	public void insert(int num, int sub)
	{
		if (length < 80)
			resize();
	//	try
	//	{
			System.out.println(sub);
			for (int k = length - 1; k > sub; k--)
			{
				array1[k] = array1[k - 1];
			}
			array1[sub] = num;
			length++;
	//	}
	//	catch (RuntimeException e)
	//	{

	//	}
	}
	
	public void resize()
	{
		int[] newArray = new int[2 * length];
		System.arraycopy(array1, 0, newArray, 0, length);
		array1 = newArray;
		length *= 2;
	}
}
