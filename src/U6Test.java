// Yegor Kuznetsov
//
//

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

		out.append(
				"Sorted Alphabetically   Sorted by Length\n---------------------   ----------------\n");

		String[] b = new String[a.length];
		String[] c = new String[a.length];
		
		System.arraycopy(a, 0, b, 0, a.length);
		for (int j = 0; j < a.length - 1; j++)
		{
			for (int i = 0; i < a.length - 1; i++)
			{
				if (b[i].compareTo(b[i + 1]) > 0)
				{
					String t = b[i];
					b[i] = b[i + 1];
					b[i + 1] = t;
				}
			}
		}

		System.arraycopy(b, 0, c, 0, a.length);
		for (int j = 0; j < a.length - 1; j++)
		{
			for (int i = 0; i < a.length - 1; i++)
			{
				if (c[i].length() > c[i + 1].length())
				{
					String t = c[i];
					c[i] = c[i + 1];
					c[i + 1] = t;
				}
			}
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
