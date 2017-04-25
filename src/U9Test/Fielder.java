// Yegor Kuznetsov
//
// This is a class that represents some data specific to fielders.

public class Fielder extends BaseballPlayer
{
    private int assists;
    private int putouts;
    private int errors;
    private double fieldingPercentage;

    public Fielder(String name, int games, int assists, int putouts, int errors)
    {
        super(name, games);
        this.assists = assists;
        this.putouts = putouts;
        this.errors = errors;
        setStat();
    }

    public void setStat()
    {
        fieldingPercentage = (double) (assists + putouts) /
                (assists + putouts + errors);
    }

    public String toString()
    {
        return super.toString() + String.format(
                "Fielding Percentage: %.3f", fieldingPercentage);
    }
}
