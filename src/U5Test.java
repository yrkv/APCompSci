// Yegor Kuznetsov
//
// This is the U5Test class. It is the driver class for the DistanceChart
// class. It creates a DistanceChart object using some cites in Iowa, and
// prints out an itinerary.

public class U5Test
{

	public static void main(String[] args)
	{
		String[] names = {"Iowa City", "Ames", "Waterloo", "Ottumwa", "Burlington"};

		int[][] chart = {{0,   121, 81,  83,  82},
						 {121, 0,   96,  116, 190},
						 {81,  96,  0,   117, 154},
						 {83,  116, 117, 0,   77},
						 {82,  190, 154, 77,  0}};

		DistanceChart dc = new DistanceChart(chart, names);

		String[] itinerary = dc.makeItinerary();

		System.out.println("The Itinerary\n-------------");
		for (String city : itinerary)
			System.out.println(city);
	}
}

/*
The Itinerary
-------------
Ames
Waterloo
Iowa City
Burlington
Ottumwa
*/