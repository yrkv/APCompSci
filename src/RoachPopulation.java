// Yegor Kuznetsov
//
// This is the RoachPopulation class, used for the U1A3 driver class

public class RoachPopulation
{
	private int roaches;

	public RoachPopulation()
	{
		roaches = 100;
	}

	public void timePasses()
	{
		roaches = roaches * 2;
	}

	public void spray()
	{
		roaches = (int) (roaches * 0.25);
	}

	public int getRoaches()
	{
		return roaches;
	}
}
