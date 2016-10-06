// Yegor Kuznetsov
//
//

import javax.swing.JApplet;

public class U5A3 extends JApplet
{
	public void init()
	{
		int length = (int) (51 * Math.random() + 50);

		int[] array1 = new int[length];
		for (int i = 0; i < 50; i++)
		{
			array1[i] = (int) (5 * (Math.random() + i));
		}

		int[] array2 = new int[30];
		for (int i = 0; i < 30; i++)
		{
			array2[i] = (int) (256 * Math.random());
		}
		
		try
		{
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
				for (int k = length; k > j; k--)
				{
					array1[k] = array1[k - 1];
				}
				array1[j] = array2[i];
				length++;
			}
		}
		catch (RuntimeException e)
		{

		}
	}
}
