// Yegor Kuznetsov
//
// This class is used to calculate the postage price for something, based
// on the type of postage and the weight.

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
			if (weight <= 16)
				return 3.50;
			return 3.95 + Math.ceil((weight - 32) / 16) * 1.20;
		}
		if (type.equals("F"))
		{
			if (weight <= 13)
			{
				return 0.34 + 0.21 * Math.ceil(weight - 1);
			}
			if (weight > 13)
			{
				if (weight <= 16)
					return 3.50;
				return 3.95 + Math.ceil((weight - 32) / 16) * 1.20;
			}
		}
		return 0.00; // returns 0.00 if the postage type is invalid
	}
}