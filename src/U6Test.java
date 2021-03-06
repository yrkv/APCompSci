// Yegor Kuznetsov
//
// This program sorts an array of names alphabetically and by length, and
// finds the name "Jones" in each.

import java.awt.Container;
import java.awt.Font;
import javax.swing.JApplet;
import javax.swing.JTextArea;

public class U6Test extends JApplet
{
	private String a[] = {"Barr", "Chamberlain", "Fullam", "Gertler", "Jones",
			"Krantzler", "Ferguson", "Litchfield", "Johnson", "Sundeen", "Baker",
			"Celebucki", "Dunagan", "Eckert", "Framke", "Hoekstra", "Jackson",
			"Klupchak", "Kurtz", "Mahler", "Maxwell", "Rothermel", "Tarjan",
			"Tiller", "Turek"};

	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 12));

		out.append("Sorted Alphabetically   Sorted by Length\n"
				+ "---------------------   ----------------\n");

		String[] b = new String[a.length];
		String[] c = new String[a.length];

		System.arraycopy(a, 0, b, 0, a.length);
		int j;
		String temp;
		for (int n = 1; n < a.length; n++)
		{
			temp = b[n];
			j = n;

			while (j > 0 && temp.compareTo(b[j - 1]) < 0)
			{
				b[j] = b[j - 1];
				j--;
			}

			b[j] = temp;
		}

		System.arraycopy(b, 0, c, 0, a.length);
		for (int n = 1; n < a.length; n++)
		{
			temp = c[n];
			j = n;

			while (j > 0 && temp.length() < c[j - 1].length())
			{
				c[j] = c[j - 1];
				j--;
			}

			c[j] = temp;
		}

		out.setTabSize(24);

		for (int i = 0; i < a.length; i++)
			out.append(b[i] + "\t" + c[i] + "\n");

		out.append("\nJones at index " + binary(b, "Jones") + "\tJones at index "
				+ sequential(c, "Jones"));

		setSize(350, 500);
		Container container = getContentPane();
		container.add(out);
	}

	private int sequential(String[] arr, String target)
	{
		for (int i = 0; i < arr.length; i++)
			if (arr[i].equals(target))
				return i;
		return -1;
	}

	private int binary(String[] arr, String target)
	{
		int low = 0;
		int high = arr.length - 1;
		int mid, dif;
		while (low <= high)
		{
			mid = (low + high) / 2;
			dif = arr[mid].compareTo(target);
			if (dif == 0)
				return mid;
			else if (dif < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
}
