// Yegor Kuznetsov
//
// This is the QuickSorter class. It is used for U6A2 to sort an array of integers
// with the quick sort method, and store the time it takes.

public class QuickSorter
{
	private int[] a;

	public QuickSorter(int[] array)
	{
		a = array;
	}

	public long sort(int from, int to)
	{
		long start = System.currentTimeMillis();
		if (from >= to)  return 0;

		int p = partition(from, to);
		sort(from, p);
		sort(p+1, to);
		return System.currentTimeMillis() - start;
	}

	private int partition(int from, int to)
	{
		int temp;
		int pivot = a[from];
		int i = from - 1;
		int j = to + 1;

		while (i < j)
		{
			i++;
			while (a[i] < pivot)
				i++;

			j--;
			while (a[j] > pivot)
				j--;

			if (i < j)
			{
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		return j;
	}
	
	public int[] getArray()
	{
		return a;
	}
}
