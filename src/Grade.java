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
	
	private void setNewNumeric()
	{
		String letter = origLetter.substring(0, 1);
		String sign = origLetter.substring(1);
		
		if (letter.equals("A")) newNumeric = 4.0;
		if (letter.equals("B")) newNumeric = 3.0;
		if (letter.equals("C")) newNumeric = 2.0;
		if (letter.equals("D")) newNumeric = 1.0;
		if (letter.equals("F")) newNumeric = 0.0;
		
		if (sign.equals("-")) newNumeric -= 0.3;
		if (sign.equals("+")) newNumeric += 0.3;
		
		if (newNumeric > 4.0) newNumeric = 4.0;
	}
	
	private void setNewLetter()
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
