// Yegor Kuznetsov
//
// This class is used for tallying some things.

public class Tally
{
    private String[] item;
    private int[] tally;

    public Tally(String[] outcomes)
    {
        item = outcomes.clone();
        tally = new int[item.length];
    }

    public void process(Measurable x) {
        for (int i = 0; i < tally.length; i++) {
            if (x.getResult().equals(item[i]))
                tally[i]++;
        }
    }

    public int[] getTally()
    {
        return tally;
    }
}
