// Yegor Kuznetsov
//
// This is the code for a DataSet class that can handle
// any class that implements Measurable.

public class DataSet
{
    private static double max;
    private static double min;
    private static double ave;
    private static double sum;
    private static int count;

    public DataSet()
    {
        max = 0;
        min = 0;
        ave = 0;
        sum = 0;
        count = 0;
    }

    public DataSet(Measurable x)
    {
        count++;
        double measure = x.getMeasure();
        sum += measure;
        if (count == 1)
        {
            max = measure;
            min = measure;
        }
        else
        {
            if (measure > max)
                max = measure;
            if (measure < min)
                min = measure;
        }
        ave = sum / count;
    }

    public static double getMax()
    {
        return max;
    }

    public static double getMin()
    {
        return min;
    }

    public static double getAve()
    {
        return ave;
    }
}
