// Yegor Kuznetsov
//
// This program is the driver class, and tests the methods of the new
// RoachPopulation class

public class U1A3
{
	public static void main(String[] args)
	{
		RoachPopulation population = new RoachPopulation();

		population.timePasses();
		System.out.println(population.getRoaches());

		population.spray();
		System.out.println(population.getRoaches());

		population.spray();
		System.out.println(population.getRoaches());

		population.timePasses();
		System.out.println(population.getRoaches());
	}
}

/*
200
50
12
24
*/