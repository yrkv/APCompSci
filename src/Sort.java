// Yegor Kuznetsov
//
// This is the Sort class. It is used for U6A1 to sort an array of integers
// with 2 different methods, and store the time it takes.

public class Sort
{
	private int[] array;

	public Sort(int[] array)
	{
		this.array = array;
	}

	public long selectionSort()
	{
		long start = System.currentTimeMillis();
		int minPos, temp;

		for (int j = 0; j < array.length - 1; j++)
		{
			minPos = j;

			for (int k = j + 1; k < array.length; k++)
			{
				if (array[k] < array[minPos])
					minPos = k;
			}

			temp = array[j];
			array[j] = array[minPos];
			array[minPos] = temp;
		}
		return System.currentTimeMillis() - start;
	}

	public long insertionSort()
	{
		long start = System.currentTimeMillis();
		int j, temp;

		for (int n = 1; n < array.length; n++)
		{
			temp = array[n];
			j = n;

			while (j > 0 && temp < array[j - 1])
			{
				array[j] = array[j - 1];
				j--;
			}

			array[j] = temp;
		}
		return System.currentTimeMillis() - start;
	}

	public int[] getArray()
	{
		return array;
	}
}
