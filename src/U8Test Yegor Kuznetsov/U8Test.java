// Yegor Kuznetsov
//
// This is the driver class for the Unit 8 Test project.
// It rolls some dice and processes some quiz scores.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;

public class U8Test
{
    public static void main(String[] args)
    {
        String[] a = new String[11];
        for (int aa = 0; aa < 11; aa++)
            a[aa] = (aa + 2) + "";

        String[] aaa = {"A", "B", "C", "D", "F"};

        JFrame aaaa = new JFrame("Aaaaaaaaaaaaaaa");
        aaaa.setVisible(true);
        aaaa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aaaa.setSize(160, 400);

        Tally aaaaa = new Tally(a);
        for (int aa = 0; aa < 100; aa++)
            aaaaa.process(new Dice((int) (Math.random() * 6 + 1),
                    (int) (Math.random() * 6 + 1)));

        Tally aaaaaa = new Tally(aaa);
        for (int aa = 0; aa < 100; aa++)
            aaaaaa.process(new Quiz((int) (Math.random() * 51 + 50)));

        JTextArea aaaaaaa = new JTextArea();
        aaaa.add(aaaaaaa);
        aaaaaaa.setFont(new Font("Monospaced", Font.PLAIN, 9));

        aaaaaaa.append("\tDice Tally\n");
        aaaaaaa.append("\t----------\n\n");
        aaaaaaa.append("Item\t\tTally\n");
        aaaaaaa.append("----\t\t-----");
        for (int aa = 0; aa < a.length; aa++)
            aaaaaaa.append("\n " + a[aa] + "\t\t " + aaaaa.getTally()[aa]);
        aaaaaaa.append("\n\n\n\n");
        aaaaaaa.append("\tQuiz Tally\n");
        aaaaaaa.append("\t----------\n\n");
        aaaaaaa.append("Item\t\tTally\n");
        aaaaaaa.append("----\t\t-----");
        for (int aa = 0; aa < aaa.length; aa++)
            aaaaaaa.append("\n " + aaa[aa] + "\t\t " + aaaaaa.getTally()[aa]);
    }
}
