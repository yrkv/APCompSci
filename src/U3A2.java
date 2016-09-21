// Yegor Kuznetsov
//
//

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class U3A2 extends Applet
{
	private String name;
	private String status;
	private String blind;
	private String over65;
	private String spouseBlind;
	private String spouseOver65;
	private int exemptions;
	private int income;
	private int taxWithheld;
	private double tax;
	
	
	public void init()
	{
		name           = JOptionPane.showInputDialog("Enter your name:");
		status         = JOptionPane.showInputDialog("Enter Filing Status - Single(S) or Married(M):");
		blind          = JOptionPane.showInputDialog("Are you blind? Yes or No:");
		over65         = JOptionPane.showInputDialog("Are you over 65? Yes or No:");
		exemptions     = Integer.parseInt(JOptionPane.showInputDialog("Enter total number of exemptions:"));
		income         = Integer.parseInt(JOptionPane.showInputDialog("Enter wages, salaries, & tips:"));
		taxWithheld = Integer.parseInt(JOptionPane.showInputDialog("Enter income tax Withheld:"));
		
		if (status.equals("M"))
		{
			spouseBlind  = JOptionPane.showInputDialog("Is your spouse blind? Yes or No:");
			spouseOver65 = JOptionPane.showInputDialog("Is your spouse over 65? Yes or No:");
		}
		else
		{
			spouseBlind  = "Yes";
			spouseOver65 = "No";
		}
		
		int deductions = exemptions + 
				(blind.equals("Yes") ? 1 : 0) + 
				(over65.equals("Yes") ? 1 : 0) + 
				(spouseBlind.equals("Yes") ? 1 : 0) + 
				(spouseOver65.equals("Yes") ? 1 : 0);
		
		income -= deductions * 10000;
		
		if (status.equals("S"))
		{
			if (income > 0 && income <= 21450)
			{
				tax = 0.15 * income;
			}
			if (income > 21540 && income <= 51900)
			{
				tax = 3217.50 + 0.28 * (income - 21450);
			}
			if (income > 51900)
			{
				tax = 11743.50 + 0.31 * (income - 51900);
			}
		}
		
		if (status.equals("M"))
		{
			if (income > 0 && income <= 35800)
			{
				tax = 0.15 * income;
			}
			if (income > 35800 && income <= 86500)
			{
				tax = 5370.00 + 0.28 * (income - 35800);
			}
			if (income > 86500)
			{
				tax = 19566.00 + 0.31 * (income - 86500);
			}
		}
		
		tax -= taxWithheld;
		
		setBackground(Color.white);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		
		Font font = new Font("Monospaced", Font.PLAIN, 16);
		g.setFont(font);
		g.drawString(name, 25, 50);
	}
}
