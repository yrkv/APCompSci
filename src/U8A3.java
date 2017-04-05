// Yegor Kuznetsov
//
// This is the driver class for a game of Hearts, played by 5 people

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class U8A3
{
    public static void main(String[] args)
    {
        ArrayList<Card> cards = new ArrayList<>(5);

        for (int i = 0; i < 5; i++)
        {
            String input = JOptionPane.showInputDialog("");
            StringTokenizer st = new StringTokenizer(input);
            cards.add(new Card(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        Trick trick = new Trick(cards);

        System.out.println("The Trick:\n");

        System.out.println(trick.toString());

        System.out.println("Winning Card = " + trick.getWinner().toString());

        System.out.println("\nPoints in Trick = " + trick.getTotalPoints());
    }
}
