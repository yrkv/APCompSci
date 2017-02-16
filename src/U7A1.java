// Yegor Kuznetsov
//
// This is a driver class to test the BankAccount_Old class. It creates
// two accounts and moves around some virtual money.

import javax.swing.JTextArea;
import javax.swing.JApplet;
import java.awt.Font;
import java.awt.Container;

public class U7A1 extends JApplet
{
    public void init()
    {
        JTextArea out = new JTextArea();
        out.setFont(new Font("Monospaced", Font.PLAIN, 16));
        out.append("Account Information\n-------------------\n\n");

        BankAccount_Old account1 = new BankAccount_Old();
        BankAccount_Old account2 = new BankAccount_Old(1500);

        out.append("Initial Balance for Account " + account1.getAccountNumber() +
                " = $ " + String.format("%.2f", account1.getBalance()));
        out.append("\nInitial Balance for Account " + account2.getAccountNumber() +
                " = $ " + String.format("%.2f", account2.getBalance()));

        out.append("\n\n" + account1.deposit(300));
        out.append("\n" + account2.deposit(200));
        out.append("\n" + account1.withdraw(250));
        out.append("\n" + account2.withdraw(125));

        account1.calculate();
        account2.calculate();

        out.append("\n" + BankAccount_Old.transfer(account1, account2, 550));

        account1.calculate();
        account2.calculate();

        out.append("\n\nFinal Balance for Account " + account1.getAccountNumber() +
                " = $ " + String.format("%.2f", account1.getBalance()));
        out.append("\nFinal Balance for Account " + account2.getAccountNumber() +
                " = $ " + String.format("%.2f", account2.getBalance()));

        out.append(String.format("\n\nInterest Rate = %.1f %%",
                BankAccount_Old.getInterestRate()));

        setSize(500, 420);
        Container container = getContentPane();
        container.add(out);
    }
}
