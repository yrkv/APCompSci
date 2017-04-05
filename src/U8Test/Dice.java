// Yegor Kuznetsov
//
// This class is used to simulate the rolling of 2 dice.

public class Dice implements Measurable
{
    private int die1;
    private int die2;
    private String sum;

    public Dice(int a, int b)
    {
        die1 = a;
        die2 = b;
        setSum();
    }

    private void setSum()
    {
        sum = die1 + die2 + "";
    }

    public String getResult()
    {
        return sum;
    }
}
