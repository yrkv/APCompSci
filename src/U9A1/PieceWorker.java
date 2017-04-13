// Yegor Kuznetsov
//
// This is a subclass that extends Worker.
// It handles workers that get paid for each piece.

public class PieceWorker extends Worker
{
    private int hoursWorked;

    public PieceWorker(String name, double hourlyWage, int hoursWorked)
    {
        super(name, hourlyWage);
        this.hoursWorked = hoursWorked;
    }

    public double Wage(int pieces)
    {
        return super.computePay(hoursWorked) + computePay(pieces);
    }

    public double computePay(int numOfPieces)
    {
        return numOfPieces * 0.12;
    }
}
