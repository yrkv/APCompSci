// Yegor Kuznetsov
//
// This is the driver class for the Unit 8 Test project.
// It rolls some dice and processes some quiz scores.

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;

public class U8Test
{
    public static void main(String[] args)
    {
        String[] outcomesDice = new String[11];
        for (int i = 0; i < 11; i++)
            outcomesDice[i] = (i + 2) + "";

        String[] outcomesQuiz = {"A", "B", "C", "D", "F"};

        JFrame frame = new JFrame("Aaaaaaaaaaaaaaa");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(160, 400);

        Tally diceTally = new Tally(outcomesDice);
        for (int i = 0; i < 100; i++)
            diceTally.process(new Dice((int) (Math.random() * 6 + 1),
                    (int) (Math.random() * 6 + 1)));

        Tally quizTally = new Tally(outcomesQuiz);
        for (int i = 0; i < 100; i++)
            quizTally.process(new Quiz((int) (Math.random() * 51 + 50)));

        JTextArea out = new JTextArea();
        frame.add(out);
        out.setFont(new Font("Monospaced", Font.PLAIN, 9));

        out.append("\tDice Tally\n");
        out.append("\t----------\n\n");
        out.append("Item\t\tTally\n");
        out.append("----\t\t-----");
        for (int i = 0; i < outcomesDice.length; i++)
            out.append("\n " + outcomesDice[i] + "\t\t " + diceTally.getTally()[i]);
        out.append("\n\n\n\n");
        out.append("\tQuiz Tally\n");
        out.append("\t----------\n\n");
        out.append("Item\t\tTally\n");
        out.append("----\t\t-----");
        for (int i = 0; i < outcomesQuiz.length; i++)
            out.append("\n " + outcomesQuiz[i] + "\t\t " + quizTally.getTally()[i]);
    }
}
