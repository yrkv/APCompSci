// Yegor Kuznetsov
//
// This is the Trick class. It is a trick in the game Hearts.
// It does some stuff with cards.

import java.util.ArrayList;

public class Trick
{
    private ArrayList<Card> cards;
    private int totalPoints;

    public Trick(ArrayList<Card> cards)
    {
        this.cards = cards;
        setTotalPoints();
    }

    private void setTotalPoints()
    {
        totalPoints = 0;
        for (Card card: cards)
            totalPoints += card.getPoints();
    }

    public int getTotalPoints()
    {
        return totalPoints;
    }

    public String toString()
    {
        String out = "";
        for (Card card: cards)
            out += card.toString() + "\n";
        return out;
    }

    public Card getWinner()
    {
        Card winner = cards.get(0);
        for (Card card: cards)
            if (card.getSuit().equals(winner.getSuit()))
                if (card.compareTo(winner) > 0)
                    winner = card;

        return winner;
    }
}
