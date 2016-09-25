

public class Postage
{
	String type;
	double weight;
	
	public Postage(String type, double weight)
	{
		this.type = type;
		this.weight = weight;
	}
	
	public double calculate()
	{
		if (type.equals("P")) 
		{
			if (weight  <= 16) return 3.50;
			return 3.95 + (int) (weight - 32) / 16 * 1.20;
		}
		if (type.equals("F"))
		{
			34 + 21 * (weight - 1);
		}
	}
}