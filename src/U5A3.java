// Yegor Kuznetsov
//
//

import javax.swing.JApplet;

public class U5A3 extends JApplet
{
	public void init()
	{
		int length = (int) (51 * Math.random() + 50);
		
		int[] array = new int[length];
		for (int i = 0; i < 50; i++)
		{
			array[i] = (int) (5 * (Math.random() + i));
		}
		
		int[] array2 = new int[30];
		for (int i = 0; i < 30; i++)
		{
			array2[i] = (int) (256 * Math.random());
		}
		
		try
		{
			
		}
		catch (RuntimeException e)
		{
			
		}
	}
}
