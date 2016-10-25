// Yegor Kuznetsov
//
// This is the MergeSorter class. It is used for U6A2 to sort an array of integers
// with the merge sort method, and store the time it takes.

public class MergeSorter
{
	private int[] a;

	public MergeSorter(int[] array)
	{
		a = array;
	}

	public long sort()
	{
		long start = System.currentTimeMillis();
		if (a.length <= 1) return 0;

		int[] first = new int[a.length/2];
		int[] second = new int[a.length - first.length];

		System.arraycopy(a,0,first,0,first.length);
		System.arraycopy(a,first.length,second,0,second.length);

		MergeSorter firstSorter = new MergeSorter(first);
		MergeSorter secondSorter = new MergeSorter(second);

		firstSorter.sort();
		secondSorter.sort();
		merge(first,second);
		return System.currentTimeMillis() - start;
	}

	private void merge(int[] first, int[] second)
	{
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < first.length && j < second.length)
		{
			if (first[i] < second[j])
			{
				a[k] = first[i];
				i++;
			}
			else
			{
				a[k] = second[j];
				j++;
			}
			k++;
		}

		System.arraycopy(first,i,a,k,first.length-i);
		System.arraycopy(second,j,a,k,second.length-j);
	}
	
	public int[] getArray()
	{
		return a;
	}
}
