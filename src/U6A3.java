// Yegor Kuznetsov
//
// This program compares the efficiency of the binary and sequential search
// algorithms using an array of 300 integers.

import javax.swing.JApplet;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTextArea;

public class U6A3 extends JApplet
{
	private int[] arr = new int[300];
	private int[] target = {2, 2629, 11176, 27032, 43661};

	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 12));

		buildArray();

		out.append("The Array\n\n");
		for (int l = 0; l < 20; l++)
		{
			for (int c = 0; c < 15; c++)
				out.append(arr[l * 15 + c] + "\t");
			out.append("\n");
		}

		out.append("\n\n\n\n");

		out.append("Search Comparisons using # of visits to the Array\n\n");
		out.append("Number\tSequential\tBinary\n");
		out.append("------\t----------\t------\n");

		for (int i = 0; i < target.length; i++)
		{
			String s = Sequential(target[i]) == -1 ? "Not Found"
					: Sequential(target[i]) + "\t";
			String b = Binary(target[i]) == -1 ? "Not Found"
					: "" + Binary(target[i]);
			out.append(target[i] + "\t" + s + "\t" + b + "\n");
		}

		setSize(1000, 650);
		Container container = getContentPane();
		container.add(out);
	}

	private void buildArray()
	{
		arr[0] = 1;
		for (int i = 1; i < 300; i++)
			arr[i] = arr[i - 1] + i;
	}

	private int Sequential(int target)
	{
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == target)
				return i + 1;
		return -1;
	}

	private int Binary(int target)
	{
		int low = 0;
		int high = arr.length - 1;
		int mid, dif, count = 0;

		while (low <= high)
		{
			count++;
			mid = (low + high) / 2;
			dif = arr[mid] - target;

			if (dif == 0)
				return count;
			else if (dif < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}
