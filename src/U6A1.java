// Yegor Kuznetsov
//
// This program compares the speed of the insertion and selection sorts. It
// generates 10000 random numbers between 0 and 999 inclusive, and runs the
// 2 sorts, displaying the times.

import java.awt.Container;
import java.awt.Font;
import java.util.Random;
import javax.swing.JApplet;
import javax.swing.JTextArea;

public class U6A1 extends JApplet
{
	private int[] a1 = new int[10000];
	private int[] a2 = new int[10000];

	public void init()
	{
		JTextArea out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 12));

		buildArrays();

		out.append("Unsorted Array\n\n");
		for (int i = 0; i < 15; i++)
			out.append(a1[i] + "\t");
		out.append("\n    -\n    -\n    -\n");
		for (int i = 9985; i < 10000; i++)
			out.append(a1[i] + "\t");

		Sort selection = new Sort(a1);
		long selectionTime = selection.selectionSort();
		int[] selectionArray = selection.getArray();

		out.append("\n\n\nAfter Selection Sort\n\n");
		for (int i = 0; i < 15; i++)
			out.append(selectionArray[i] + "\t");
		out.append("\n    -\n    -\n    -\n");
		for (int i = 9985; i < 10000; i++)
			out.append(selectionArray[i] + "\t");
		out.append("\n\nTime = " + selectionTime + " milliseconds");

		Sort insertion = new Sort(a2);
		long insertionTime = insertion.insertionSort();
		int[] insertionArray = insertion.getArray();

		out.append("\n\n\nAfter Insertion Sort\n\n");
		for (int i = 0; i < 15; i++)
			out.append(insertionArray[i] + "\t");
		out.append("\n    -\n    -\n    -\n");
		for (int i = 9985; i < 10000; i++)
			out.append(insertionArray[i] + "\t");
		out.append("\n\nTime = " + insertionTime + " milliseconds");

		setSize(1000, 500);
		Container container = getContentPane();
		container.add(out);
	}

	private void buildArrays()
	{
		Random random = new Random();
		for (int i = 0; i < 10000; i++)
		{
			a1[i] = random.nextInt(1000);
			a2[i] = a1[i];
		}
	}
}
