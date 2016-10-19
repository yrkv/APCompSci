// Yegor Kuznetsov
//
//

import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class U5A4 extends JFrame
{
	private String[][] board = {{" ", " ", " ", " ", " ", " "},
								{" ", " ", "*", " ", " ", " "}, 
								{" ", " ", " ", "*", " ", " "},
								{" ", "*", "*", "*", " ", " "}, 
								{" ", " ", " ", " ", " ", " "},
								{" ", " ", " ", " ", " ", " "}};
	
	private JTextArea out;

	public U5A4()
	{
		Container container = getContentPane();
		out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.PLAIN, 10));
		out.setText("Generation 0\n");
		container.add(out);
	}
	
	public static void main(String[] args)
	{
		U5A4 application = new U5A4();
	}
}
