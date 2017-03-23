// Yegor Kuznetsov
//
// This is the BBPlayer class. It does
// some stuff with strings and arrays.
// It also implements an interface to send data.
// The data is only used if ppg > 10.

import java.util.StringTokenizer;

public class BBPlayer implements Measurable
{
    private int num;
    private int year;
    private String pos;
    private double ppg;

    public BBPlayer(String line)
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

    public double getMeasure()
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

    public boolean accept()
    {
        return ppg > 10;
    }
}
