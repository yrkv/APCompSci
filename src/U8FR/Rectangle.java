
/**
 * Created by yekuz20 on 4/6/2017.
 */
public class Rectangle implements Shape, Comparable
{
    private double length;
    private double width;

    public Rectangle(double len, double wid) {
        length = len;
        width = wid;
    }

    public double area()
    {
        return length * width;
    }

    public double perimeter()
    {
        return 2*(length + width);
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
        return "Rectangle[" + length + ", " + width + "]";
    }
}
