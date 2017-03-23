// Yegor Kuznetsov
//
// This is a driver class meant to show polymorphism.
// It handles BBPlayer objects and BankAccount objects
// with the same methods in the same class.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class U8A2
{
    private JTextArea out = new JTextArea();

    public static void main(String[] args)
    {
        U8A2 u8a2 = new U8A2();
    }

    public U8A2()
    {
        JFrame frame = new JFrame();
        out.setFont(new Font("Monospaced", Font.BOLD, 14));
        frame.add(out);
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        testBBPlayer();
        testBankAccount();
    }

    private void testBBPlayer()
    {
        DataSet dataSet = new DataSet();
        try
        {
            Scanner in = new Scanner(new File("U:\\STUDENT\\PROJECTS\\West Projects"
                    + "\\Computer Science\\JavaData\\u7test.txt"));
            for (int i = 0; i < 5; i++) {
                String input = in.nextLine();
                BBPlayer player = new BBPlayer(input);
                dataSet = new DataSet(player);
            }
            in.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }

        out.append("BBplayer Stats\n");
        out.append("--------------\n\n");
        out.append("Minimum points Per Game = " + DataSet.getMin() + "\n\n");
        out.append("Maximum points Per Game = " + DataSet.getMax() + "\n\n");
        out.append(String.format("Average Points Per Game = %.2f\n\n", DataSet.getAve()));
    }

    private void testBankAccount()
    {
        DataSet dataSet = new DataSet();
        try
        {
            Scanner in = new Scanner(new File("U:\\STUDENT\\PROJECTS\\West Projects"
                    + "\\Computer Science\\JavaData\\myCreditUnion.txt"));
            while (in.hasNext())
            {
                StringTokenizer st = new StringTokenizer(in.nextLine());
                String num = st.nextToken();
                double bal = Double.parseDouble(st.nextToken());
                BankAccount account = new BankAccount(num, bal);
                dataSet = new DataSet(account);
            }
            in.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }

        out.append("\nBankAccount Stats\n");
        out.append("-----------------\n\n");
        out.append("Minimum Bank Account = " + DataSet.getMin() + "\n\n");
        out.append("Maximum Bank Account = " + DataSet.getMax() + "\n\n");
        out.append(String.format("Average Bank Account = %.2f\n\n", DataSet.getAve()));
    }
}
