// Yegor Kuznetsov
//
// This program shows dialog boxes that ask for your tax information,
// and calculates what you owe. It then displays that in an applet window.

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class U3A2 extends Applet
{
	private double tax;
	private String name;
	
	public void init()
	{
		String status, blind, over65, spouseBlind, spouseOver65;
		int exemptions, income, taxWithheld;
		
		String m1 = "Enter your name:";
		String m2 = "Enter Filing Status - Single(S) or Married(M):";
		String m3 = "Are you blind? Yes or No:";
		String m4 = "Are you over 65? Yes or No:";
		String m5 = "Is your spouse blind? Yes or No:";
		String m6 = "Is your spouse over 65? Yes or No:";
		String m7 = "Enter total number of exemptions:";
		String m8 = "Enter wages, salaries, & tips:";
		String m9 = "Enter income tax Withheld:";
		
		name   = JOptionPane.showInputDialog(m1);
		status = JOptionPane.showInputDialog(m2);
		blind  = JOptionPane.showInputDialog(m3);
		over65 = JOptionPane.showInputDialog(m4);
		
		if (status.equals("M"))
		{
			spouseBlind  = JOptionPane.showInputDialog(m5);
			spouseOver65 = JOptionPane.showInputDialog(m6);
		}
		else
		{
			spouseBlind  = "No";
			spouseOver65 = "No";
		}
		
		exemptions  = Integer.parseInt(JOptionPane.showInputDialog(m7));
		income      = Integer.parseInt(JOptionPane.showInputDialog(m8));
		taxWithheld = Integer.parseInt(JOptionPane.showInputDialog(m9));
		
		int deductions = exemptions + 
				(blind.equals("Yes") ? 1 : 0) + 
				(over65.equals("Yes") ? 1 : 0) + 
				(spouseBlind.equals("Yes") ? 1 : 0) + 
				(spouseOver65.equals("Yes") ? 1 : 0);
		
		income -= deductions * 1000;
		
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
		setSize(400, 300);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		
		Font font = new Font("Monospaced", Font.BOLD, 16);
		g.setFont(font);
		g.drawString(name + ", below you will find", 10, 50);
		g.drawString("the results of your Tax Inquiry.", 10, 75);
		
		String out = String.format("%7.2f", Math.abs(tax));
		
		g.drawString((tax > 0 ? "Owe" : "Refund") + " =   $" + out, 100, 125);
	}
}
