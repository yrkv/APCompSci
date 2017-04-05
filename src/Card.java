// Yegor Kuznetsov
//
// This is the card class. It implements the Comparable interface.
// It can be compared because it implements the Comparable interface.

public class Card implements Comparable
{
    private String suit;
    private int value;
    private int points;

    public Card(String suit, int value)
    {
        this.suit = suit;
        this.value = value;
        setPoints();
    }

    private void setPoints()
    {
        points = (suit.equals("Hearts")) ?
                1 : (value == 12 && suit.equals("Spades")) ?
                13 : 0;
    }

    public String toString()
    {
        return ((value <= 10) ?
                value : (value == 11) ?
                "Jack" : (value == 12) ?
                "Queen" : (value == 13) ?
                "King" :
                "Ace") + " of " + suit;
    }

    public int compareTo(Object o)
    {
        return this.getValue() - ((Card) o).getValue();
    }

    public int getPoints()
    {
        return points;
    }

    public int getValue()
    {
        return value;
    }

    public String getSuit()
    {
        return suit;
    }
}
