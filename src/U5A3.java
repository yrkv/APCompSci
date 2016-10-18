// Yegor Kuznetsov
//
// This program creates an array with a length between 50 and 100, and puts
// 50 integers in it in ascending order. It then inserts 30 random integers
// into it, and displays the array before and after.

import java.awt.Container;
import java.awt.Font;
import javax.swing.JApplet;
import javax.swing.JTextArea;

public class U5A3 extends JApplet
{
	private int length;
	private int[] array1;
	private int[] array2;
	private JTextArea out;

	public void init()
	{
		out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 12));
		out.append("Original Array\n");

		fillArray();

		array2 = new int[30];
		for (int i = 0; i < 30; i++)
		{
			array2[i] = (int) (256 * Math.random());
		}

		for (int i = 0; i < 30; i++)
		{
			int j = 0;
			boolean found = false;
			while (j < length - 1 && !found)
			{
				if (array2[i] > array1[j] && !(array1[j] == 0 && j > 1))
					j++;
				else
					found = true;
			}
			insert(array2[i], j);
		}

		out.append("\n\n\nUpdated Array\n");
		for (int i = 0; i < 80; i++)
		{
			if (i % 10 == 0)
				out.append("\n");
			out.append(array1[i] + "\t");
		}
		out.append("\n\nArrayLength = " + length);

		setSize(750, 500);
		Container container = getContentPane();
		container.add(out);
	}

	public void fillArray()
	{
		length = (int) (51 * Math.random() + 50);
		array1 = new int[length];
		for (int i = 0; i < 50; i++)
		{
			array1[i] = (int) (5 * (Math.random() + i));
			if (i % 10 == 0)
				out.append("\n");
			out.append(array1[i] + "\t");
		}
		out.append("\n\nArrayLength = " + length);
	}

	public void insert(int num, int sub)
	{
		if (length < 80)
			resize();
		try
		{
			for (int k = length - 1; k > sub; k--)
			{
				array1[k] = array1[k - 1];
			}
			array1[sub] = num;
		}
		catch (RuntimeException e)
		{
			resize();
		}
	}

	public void resize()
	{
		int[] newArray = new int[2 * length];
		System.arraycopy(array1, 0, newArray, 0, length);
		array1 = newArray;
		length *= 2;
	}
}
