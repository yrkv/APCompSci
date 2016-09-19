// Yegor Kuznetsov
//
// This class converts letter grades into numeric grades, and numeric
// grades into letter grades. It has a parametric constructor that accepts
// the old numeric and letter grades, and sets some instance fields to the
// new grades.

public class Grade
{
	private String origLetter;
	private String newLetter;
	private double origNumeric;
	private double newNumeric;
	
	public Grade(String letter, double number)
	{
		origLetter = letter;
		origNumeric = number;
		setNewNumeric();
		setNewLetter();
	}
	
	public void setNewNumeric()
	{
		if (origLetter.equals("A+")) newNumeric = 4.0;
		if (origLetter.equals("A"))  newNumeric = 4.0;
		if (origLetter.equals("A-")) newNumeric = 3.7;
		if (origLetter.equals("B+")) newNumeric = 3.3;
		if (origLetter.equals("B"))  newNumeric = 3.0;
		if (origLetter.equals("B-")) newNumeric = 2.7;
		if (origLetter.equals("C+")) newNumeric = 2.3;
		if (origLetter.equals("C"))  newNumeric = 2.0;
		if (origLetter.equals("C-")) newNumeric = 1.7;
		if (origLetter.equals("D+")) newNumeric = 1.3;
		if (origLetter.equals("D"))  newNumeric = 1.0;
		if (origLetter.equals("D-")) newNumeric = 0.7;
		if (origLetter.equals("F"))  newNumeric = 0.0;
	}
	
	public void setNewLetter()
	{
		if (origNumeric == 4.00)                       newLetter = "A+";
		if (origNumeric < 4.00 && origNumeric >= 3.85) newLetter = "A";
		if (origNumeric < 3.85 && origNumeric >= 3.50) newLetter = "A-";
		if (origNumeric < 3.50 && origNumeric >= 3.15) newLetter = "B+";
		if (origNumeric < 3.15 && origNumeric >= 2.85) newLetter = "B";
		if (origNumeric < 2.85 && origNumeric >= 2.50) newLetter = "B-";
		if (origNumeric < 2.50 && origNumeric >= 2.15) newLetter = "C+";
		if (origNumeric < 2.15 && origNumeric >= 1.85) newLetter = "C";
		if (origNumeric < 1.85 && origNumeric >= 1.50) newLetter = "C-";
		if (origNumeric < 1.50 && origNumeric >= 1.15) newLetter = "D+";
		if (origNumeric < 1.15 && origNumeric >= 0.85) newLetter = "D";
		if (origNumeric < 0.85 && origNumeric >= 0.50) newLetter = "D-";
		if (origNumeric < 0.50 && origNumeric >= 0.00) newLetter = "F";
	}
	
	public double getNewNumeric()
	{
		return newNumeric;
	}
	
	public String getNewLetter()
	{
		return newLetter;
	}
}
