// Yegor Kuznetsov
//
// This is a class used for the unit 5 test project. It stores a chart of
// city names and distances, and uses it to calculate a path from city to
// city.

public class DistanceChart
{
	private String[] cityNames;
	private int[][] distances;

	public DistanceChart(int[][] d, String[] cn)
	{
		distances = d;
		cityNames = cn;
	}

	public int findRemoteCity()
	{
		int largestIndex = 0;
		int largestSum = 0;
		for (int i = 0; i < cityNames.length; i++)
		{
			int sum = 0;
			for (int j = 0; j < distances[i].length; j++)
			{
				sum += distances[i][j];
			}

			largestIndex = sum > largestSum ? i : largestIndex;
			largestSum = sum > largestSum ? sum : largestSum;
		}
		return largestIndex;
	}

	public int findNearestCity(int i)
	{
		int leastIndex = 0;
		int leastDistance = Integer.MAX_VALUE;
		for (int j = 0; j < cityNames.length; j++)
		{
			if (j == i)
				continue;
			int d = distances[i][j];
			leastIndex = d < leastDistance ? j : leastIndex;
			leastDistance = d < leastDistance ? d : leastDistance;
		}

		for (int j = 0; j < cityNames.length; j++)
		{
			distances[j][leastIndex] = Integer.MAX_VALUE;
		}

		return leastIndex;
	}

	public String[] makeItinerary()
	{
		int[] arr = new int[cityNames.length];
		arr[0] = findRemoteCity();

		for (int i = 1; i < cityNames.length; i++)
			arr[i] = findNearestCity(arr[i - 1]);

		String[] out = new String[cityNames.length];
		for (int i = 0; i < cityNames.length; i++)
			out[i] = cityNames[arr[i]];

		return out;
	}
}
