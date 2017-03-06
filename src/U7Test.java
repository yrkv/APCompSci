// Yegor Kuznetsov
//
// This is the driver class for BBPlayer

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class U7Test extends JFrame
{
    private ArrayList<BBPlayer> bbPlayers = new ArrayList<BBPlayer>();
    private JTextArea out = new JTextArea();

    public static void main(String[] args)
    {
        U7Test u7Test = new U7Test();
    }

    public U7Test()
    {
        JFrame frame = new JFrame();
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        out.setFont(new Font("Monospaced", Font.BOLD, 16));
        frame.add(out);
        frame.setVisible(true);

        try
        {
            Scanner scanner = new Scanner(new File(
                    "U:\\STUDENT\\PROJECTS\\West Projects"
                    +"\\Computer Science\\JavaData\\u7test.txt"));
            while (scanner.hasNextLine())
                bbPlayers.add(new BBPlayer(scanner.nextLine()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        PrintList();
    }

    public void PrintList()
    {
        out.append("Original List\n\n");
        out.append("Number\tYear\tPosition\tPoint Per Game\n");
        out.append("------\t----\t--------\t--------------\n");
        for (BBPlayer bb: bbPlayers)
            out.append("  " + bb.getNum() + "\t " + bb.getYear()
                    + "\t   " + bb.getPos() + "\t\t     " + bb.getPpg() + "\n");

        out.append("\n\n\n");

        Sort();

        out.append("Sorted List\n\n");
        out.append("Number\tYear\tPosition\tPoint Per Game\n");
        out.append("------\t----\t--------\t--------------\n");
        for (BBPlayer bb: bbPlayers)
            out.append("  " + bb.getNum() + "\t " + bb.getYear()
                    + "\t   " + bb.getPos() + "\t\t     " + bb.getPpg() + "\n");
    }

    public void Sort()
    {
        int j;
        BBPlayer temp;

        for (int n = 1; n < bbPlayers.size(); n++)
        {
            temp = bbPlayers.get(n);
            j = n;

            while (j > 0 && temp.getPpg() > bbPlayers.get(j-1).getPpg())
            {
                bbPlayers.set(j, bbPlayers.get(j-1));
                j--;
            }

            bbPlayers.set(j, temp);
        }
    }
}
