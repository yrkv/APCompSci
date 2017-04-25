// Yegor Kuznetsov
//
// This is a class that represents some data specific to hitters.

public class Hitter extends BaseballPlayer
{
    private int atBats;
    private int hits;
    private double hittingAverage;

    public Hitter(String name, int games, int atBats, int hits)
    {
        super(name, games);
        this.atBats = atBats;
        this.hits = hits;
        setStat();
    }

    public void setStat()
    {
        hittingAverage = (double) hits / atBats;
    }

    public String toString()
    {
        return super.toString() + String.format(
                "Batting Average: %.3f", hittingAverage);
    }
}
