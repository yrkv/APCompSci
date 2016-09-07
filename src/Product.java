// Yegor Kuznetsov
//
//

public class Product
{
	private String name;
	private double cost;

	public Product(String n, double c)
	{
		name = n;
		cost = c;
	}

	public void discount(int percent)
	{
		cost = cost * (100 - percent) / 100;
	}

	public void dollarsOff(int dollars)
	{
		cost = cost - dollars;
	}

	public void tax()
	{
		final double TAX_RATE = 0.065;

		cost = cost * (1 + TAX_RATE);
	}

	public String getName()
	{
		return name;
	}
	
	public double getCost()
	{
		return cost;
	}
}
