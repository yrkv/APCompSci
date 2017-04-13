// Yegor Kuznetsov
//
// This is the driver class for U9A1. It tests a couple of worker subclasses.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;

public class U9A1
{
    private JTextArea out = new JTextArea();

    public static void main(String[] args)
    {
        new U9A1();
    }

    public U9A1()
    {
        JFrame frame = new JFrame();
        out.setFont(new Font("Monospaced", Font.BOLD, 10));
        frame.add(out);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 250);
        testHourly();
        testSalaried();
        testPiece();
    }

    private void testHourly()
    {
        out.append("Test Hourly Worker Class\n");
        out.append("------------------------\n");
        HourlyWorker worker = new HourlyWorker("John Doe", 9.48, 43);
        out.append("Wage for " + worker.getName() + " = $" + String.format("%.2f", worker.Wage()));
        out.append("\n\n\n");
    }

    private void testSalaried()
    {
        out.append("Test Salaried Worker Class\n");
        out.append("--------------------------\n");
        SalariedWorker worker = new SalariedWorker("Karen Jones", 25.76, 52);
        out.append("Wage for " + worker.getName() + " = $" + String.format("%.2f", worker.Wage()));
        out.append("\n\n\n");
    }

    private void testPiece()
    {
        out.append("Test Piece Worker Class\n");
        out.append("-----------------------\n");
        PieceWorker worker = new PieceWorker("Wesley Smith", 5.65, 36);
        out.append("Wage for " + worker.getName() + " = $" + String.format("%.2f", worker.Wage(1025)));
        out.append("\n\n\n");
    }
}
