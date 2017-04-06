import java.util.ArrayList;

/**
 * Created by yekuz20 on 4/6/2017.
 */
public class Driver
{
    public static void main(String[] args)
    {
        new Driver();
    }

    public Driver()
    {
        ArrayList<Comparable> list = new ArrayList<>();

        list.add(new Rectangle(5.2, 8.5));
        list.add(new Rectangle(3.9, 4.7));

        list.add(new RightTriangle(3.7, 5.1));
        list.add(new RightTriangle(1.8, 8.6));

        list.add(new Rectangle(8.7, 5.5));
        list.add(new RightTriangle(7.9, 6.4));

        list.add(new Rectangle(4.0, 5.0));
        list.add(new Rectangle(5.0, 4.0));

        list.add(new RightTriangle(3.0, 4.0));
        list.add(new RightTriangle(2.0, 6.0));

        for (int i = 0; i < 5; i++)
        {
            Comparable a = list.get(i*2);
            Comparable b = list.get(i*2 + 1);
            System.out.println(intToStr(a.compareTo(b), (Shape) a, (Shape) b));
        }
    }

    private String intToStr(int c, Shape a, Shape b)
    {
        if (c == -1)
            return a.toString() + " is less than " + b.toString();
        if (c == 1)
            return a.toString() + " is greater than " + b.toString();
        else
            return "Shapes are equal";
    }
}
