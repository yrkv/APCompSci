// Yegor Kuznetsov
//
// This program simulates generations of the game of life on a 6 by 6
// board, and displays them using a JFrame.

import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class U5A4 extends JFrame
{
	private String[][] board = {{" ", " ", " ", " ", " ", " "},
			{" ", " ", "*", " ", " ", " "}, {" ", " ", " ", "*", " ", " "},
			{" ", "*", "*", "*", " ", " "}, {" ", " ", " ", " ", " ", " "},
			{" ", " ", " ", " ", " ", " "}};

	private JTextArea out;

	public U5A4()
	{
		Container container = getContentPane();
		out = new JTextArea();
		out.setFont(new Font("Monospaced", Font.BOLD, 14));
		out.setText("Generation 0\n");
		container.add(out);

		printMatrix();
		changeMatrix();
		out.append("Generation 2\n");
		changeMatrix();
		printMatrix();
		changeMatrix();
		out.append("Generation 4\n");
		changeMatrix();
		printMatrix();

		setSize(400, 900);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		U5A4 application = new U5A4();

		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void printMatrix()
	{
		for (int j = 0; j < 6; j++)
		{
			out.append("|");
			for (int k = 0; k < 6; k++)
			{
				out.append(board[j][k] + "|");
			}
			out.append("\n");
			out.append("-------------\n");
		}
	}

	private void changeMatrix()
	{
		String[][] newMatrix = new String[6][6];

		for (int j = 0; j < 6; j++)
		{
			for (int k = 0; k < 6; k++)
			{
				newMatrix[j][k] = (neighbors(j, k) >= 4) ? " "
								: ((neighbors(j, k) == 3) ? "*"
								: ((neighbors(j, k) < 2) ? " "
								: ((board[j][k].equals("*") ? "*" : " "))));
			}
		}

		board = newMatrix;
	}

	private int neighbors(int row, int col)
	{
		int neighbors = 0;

		if (row > 0)
		{
			if (col > 0)
				neighbors += (board[row - 1][col - 1].equals("*")) ? 1 : 0;
			if (col < 5)
				neighbors += (board[row - 1][col + 1].equals("*")) ? 1 : 0;
			neighbors += (board[row - 1][col].equals("*")) ? 1 : 0;
		}

		if (row < 5)
		{
			if (col > 0)
				neighbors += (board[row + 1][col - 1].equals("*")) ? 1 : 0;
			if (col < 5)
				neighbors += (board[row + 1][col + 1].equals("*")) ? 1 : 0;
			neighbors += (board[row + 1][col].equals("*")) ? 1 : 0;
		}

		if (col > 0)
			neighbors += (board[row][col - 1].equals("*")) ? 1 : 0;
		if (col < 5)
			neighbors += (board[row][col + 1].equals("*")) ? 1 : 0;

		return neighbors;
	}

}
