// Yegor Kuznetsov
//
//

import javax.swing.JOptionPane;

public class U3A1
{
	public static void main(String[] args)
	{
		String letter = JOptionPane.showInputDialog("Please enter Letter Grade: ");
		String number = JOptionPane.showInputDialog("Please enter Numeric Grade: ");

		Grade grade = new Grade(letter, Double.parseDouble(number));
		
		String message = "Numeric Grade Equivalent = " + grade.getNewNumeric() + "\n\n" + "Letter Grade Equivalent = " + grade.getNewLetter();
		
		JOptionPane.showMessageDialog(null, message, "U3A1", JOptionPane.INFORMATION_MESSAGE);
	}
}
