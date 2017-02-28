// Yegor Kuznetsov
//
// This class displays a tic-tac-toe board and
// allows 2 people to play it using the mouse.
// It displays the winner when the game is over.

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe implements MouseListener
{
    private JFrame frame = new JFrame("Tic Tac Toe");
    private Board board;
    private static final int X = 0;
    private static final int O = 1;
    private int turn = 0;

    public static void main(String[] args)
    {
        TicTacToe ttt = new TicTacToe();
    }

    public void frame(){
        frame.setResizable(false);
        frame.setSize(400, 400);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                if (winner() == 0)
                {
                    g.clearRect(0, 0, this.getWidth(), this.getHeight());
                    g.setColor(Color.BLACK);
                    g.drawRect(60, 60, 240, 240);
                    g.drawLine(140, 60, 140, 300);
                    g.drawLine(220, 60, 220, 300);
                    g.drawLine(60, 140, 300, 140);
                    g.drawLine(60, 220, 300, 220);


                    Piece[][] pieces = board.getBoard();
                    for (int i = 0; i < 3; i++)
                        for (int j = 0; j < 3; j++)
                        {
                            Piece p = pieces[i][j];
                            if (p.getID().equals("X"))
                                renderX(g, j, i);
                            if (p.getID().equals("O"))
                                renderO(g, j, i);
                        }
                }
                if (winner() == 1)
                    renderX(g, 1, 1);
                if (winner() == 2)
                    renderO(g, 1, 1);
                if (winner() == 3)
                {
                    g.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
                    g.drawString("Tie", 180, 180);
                }
            }
        };

        frame.add(panel);
        panel.addMouseListener(this);
    }

    private void renderX(Graphics g, int x, int y)
    {
        g.drawLine(x*80 + 80, y*80 + 80, x*80 + 120, y*80 + 120);
        g.drawLine(x*80 + 80, y*80 + 120, x*80 + 120, y*80 + 80);
    }

    private void renderO(Graphics g, int x, int y)
    {
        g.drawOval(x*80 + 80, y*80 + 80, 40, 40);
    }

    public TicTacToe()
    {
        board = new Board(3, 3);

        for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				board.getBoard()[i][j] = new Piece();

        board.drawBoard();

        frame();
        while(winner() == 0)
            frame.repaint();

        frame.repaint();
    }

    public void mousePressed(MouseEvent e)
    {}
    public void mouseEntered(MouseEvent e)
    {}
    public void mouseExited(MouseEvent e)
    {}
    public void mouseReleased(MouseEvent e)
    {}

    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        if (60 < x && x < 300 && 60 < y && y < 300)
        {
            x = (x - 60) / 80;
            y = (y - 60) / 80;

            if (!board.isOccupied(y, x))
            {
                if (turn % 2 == X)
                    board.addPiece(new Piece("X"), y, x);

                if (turn % 2 == O)
                    board.addPiece(new Piece("O"), y, x);
                turn++;
            }

            board.drawBoard();

        }
    }

    // 0 = game not finished, 1 = X, 2 = O, 3 = tie
    private int winner()
    {
        Piece[][] pieces = board.getBoard();

        for (int i = 0; i < 3; i++)
            if (pieces[0][i].equals(pieces[1][i]) && pieces[1][i].equals(pieces[2][i]))
                if (!pieces[1][i].getID().equals(" "))
                    return (pieces[1][i].getID().equals("X")) ? 1 : 2;

        for (int i = 0; i < 3; i++)
            if (pieces[i][0].equals(pieces[i][1]) && pieces[i][1].equals(pieces[i][2]))
                if (!pieces[i][1].getID().equals(" "))
                    return (pieces[i][1].getID().equals("X")) ? 1 : 2;

        if ((pieces[0][0].equals(pieces[1][1]) && pieces[1][1].equals(pieces[2][2]))
                || (pieces[2][0].equals(pieces[1][1]) && pieces[1][1].equals(pieces[0][2])))
            if (!pieces[1][1].getID().equals(" "))
                return (pieces[1][1].getID().equals("X")) ? 1 : 2;

        if (turn > 8)
            return 3;

        return 0;
    }
}
