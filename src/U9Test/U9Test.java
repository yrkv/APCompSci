// Yegor Kuznetsov
//
// This is the driver class to create several
// baseball players and display data about them.

import java.util.ArrayList;

public class U9Test
{
    public static void main(String[] args)
    {
        ArrayList<BaseballPlayer> list = new ArrayList<>();

        list.add(new Hitter("Tyler Lawson", 29, 78, 25));
        list.add(new Hitter("Jason Brown", 16, 54, 13));
        list.add(new Pitcher("Tom Jensen", 9, 50.7, 18));
        list.add(new Pitcher("Jason Brown", 10, 72.3, 15));
        list.add(new Fielder("Willie Starks", 30, 11, 97, 4));
        list.add(new Fielder("Jason Brown", 16, 23, 6, 3));

        for (BaseballPlayer a: list)
            System.out.println(a.toString() + "\n");
    }
}

/*
Name: Tyler Lawson
Games: 29
Batting Average: 0.321

Name: Jason Brown
Games: 16
Batting Average: 0.241

Name: Tom Jensen
Games: 9
Earned Run Average: 3.20

Name: Jason Brown
Games: 10
Earned Run Average: 1.87

Name: Willie Starks
Games: 30
Fielding Percentage: 0.964

Name: Jason Brown
Games: 16
Fielding Percentage: 0.906


 */