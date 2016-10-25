// Yegor Kuznetsov
//
// This program compares the speed of the merge and quick sorts. It
// generates 5000 random numbers between 0 and 999 inclusive, and runs the
// 2 sorts, displaying the times.

import java.awt.Container;
import java.awt.Font;
import java.util.Random;
import javax.swing.JApplet;
import javax.swing.JTextArea;

public class U6A2 extends JApplet
{
	private int[] a1 = new int[5000];
	private int[] a2 = new int[5000];

	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 12));

		buildArrays();

		out.append("Unsorted Array\n\n");
		for (int i = 0; i < 15; i++)
			out.append(a1[i] + "\t");
		out.append("\n    -\n    -\n    -\n");
		for (int i = 4985; i < 5000; i++)
			out.append(a1[i] + "\t");

		MergeSorter merge = new MergeSorter(a1);
		long mergeTime = merge.sort();
		int[] mergeArray = merge.getArray();

		out.append("\n\n\nMergeSort\n\n");
		for (int i = 0; i < 15; i++)
			out.append(mergeArray[i] + "\t");
		out.append("\n    -\n    -\n    -\n");
		for (int i = 4985; i < 5000; i++)
			out.append(mergeArray[i] + "\t");
		out.append("\n\n" + mergeTime + " milliseconds");

		QuickSorter quick = new QuickSorter(a2);
		long quickTime = quick.sort(0, 4999);
		int[] quickArray = quick.getArray();

		out.append("\n\n\nQuickSort\n\n");
		for (int i = 0; i < 15; i++)
			out.append(quickArray[i] + "\t");
		out.append("\n    -\n    -\n    -\n");
		for (int i = 4985; i < 5000; i++)
			out.append(quickArray[i] + "\t");
		out.append("\n\n" + quickTime + " milliseconds");

		setSize(1000, 500);
		Container container = getContentPane();
		container.add(out);
	}

	private void buildArrays()
	{
		Random random = new Random();
		for (int i = 0; i < 5000; i++)
		{
			a1[i] = random.nextInt(1000);
			a2[i] = a1[i];
		}
	}
}
