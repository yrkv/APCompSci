// Yegor Kuznetsov
//
// This is a class that represents some basic data about a baseball player.

public abstract class BaseballPlayer
{
    private String name;
    private int gamesCount;

    public BaseballPlayer(String name, int gamesCount)
    {
        this.name = name;
        this.gamesCount = gamesCount;
    }

    public String toString()
    {
        return "Name: " + name + "\nGames: " + gamesCount + "\n";
    }

    public abstract void setStat();
}
