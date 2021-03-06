// Yegor Kuznetsov
//
// This is the BBPlayer_Old class. It does
// some stuff with strings and arrays.

import java.util.StringTokenizer;

public class BBPlayer_Old
{
    private int num;
    private int year;
    private String pos;
    private double ppg;

    public BBPlayer_Old(String line)
    {
        StringTokenizer st = new StringTokenizer(line);
        num = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
        pos = st.nextToken();
        ppg = Double.parseDouble(st.nextToken());
    }

    public int getNum()
    {
        return num;
    }

    public double getPpg()
    {
        return ppg;
    }

    public int getYear()
    {
        return year;
    }

    public String getPos()
    {
        return pos;
    }
}
