// Yegor Kuznetsov
//
// This is a class that represents some data specific to pitchers.

public class Pitcher extends BaseballPlayer
{
    private double innings;
    private int earnedRuns;
    private double era;

    public Pitcher(String name, int games, double innings, int earnedRuns)
    {
        super(name, games);
        this.innings = innings;
        this.earnedRuns = earnedRuns;
        setStat();
    }

    public void setStat()
    {
        era = (9 * earnedRuns) / innings;
    }

    public String toString()
    {
        return super.toString() + String.format("Earned Run Average: %.2f", era);
    }
}
