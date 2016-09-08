// Yegor Kuznetsov
//
// This is a driver class for the Product class. It creates three virtual
// store products. Then it discounts and taxes them, and prints out the
// name and the cost.

public class U2A1
{
	public static void main(String[] args)
	{
		Product a = new Product("Jeans", 34.95);
		Product b = new Product("Sweater", 49.99);
		Product c = new Product("Shoes", 99.95);

		a.discount(30);
		a.tax();
		System.out.printf("Item: %s \n", a.getName());
		System.out.printf("Cost: %.2f \n\n", a.getCost());

		b.discount(40);
		b.discount(30);
		b.tax();
		System.out.printf("Item: %s \n", b.getName());
		System.out.printf("Cost: %.2f \n\n", b.getCost());

		c.dollarsOff(5);
		c.discount(30);
		c.tax();
		System.out.printf("Item: %s \n", c.getName());
		System.out.printf("Cost: %.2f", c.getCost());
	}
}
