/**
 * Created by yekuz20 on 4/6/2017.
 */
public class RightTriangle implements Shape, Comparable
{
    private double leg1;
    private double leg2;

    public RightTriangle(double x, double y) {
        leg1 = x;
        leg2 = y;
    }

    public double area()
    {
        return leg1 * leg2 / 2;
    }

    public double perimeter()
    {
        return leg1 + leg2 + Math.sqrt(leg1*leg1 + leg2*leg2);
    }

    public int compareTo(Object obj)
    {
        Shape shape = (Shape) obj;
        return  (area() > shape.area()) ? 1 :
                (area() < shape.area()) ? -1 :
                (perimeter() > shape.perimeter()) ? 1 :
                (perimeter() < shape.perimeter()) ? -1 :
                0;
    }

    public String toString()
    {
        return "Right Triangle[" + leg1 + ", " + leg2 + "]";
    }
}
