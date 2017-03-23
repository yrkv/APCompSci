// Yegor Kuznetsov
//
// This is the interface for the new
// BBPlayer and BandAccount classes.
// It has a method to get the measured data,
// and a method to check if the object should be accepted.

public interface Measurable
{
    double getMeasure();
    boolean accept();
}