// Yegor Kuznetsov

public class Cylinder
{
	private double height;
	private double radius;

	public Cylinder(double height, double radius)
	{
		this.height = height;
		this.radius = radius;
	}

	public double surfaceArea()
	{
		return radius * radius * 6.28 + radius * 6.28 * height;
	}

	public double volume()
	{
		return Math.PI * radius * radius * height;
	}

	public double getHeight()
	{
		return height;
	}

	public double getRadius()
	{
		return radius;
	}
}
