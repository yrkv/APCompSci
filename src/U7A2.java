// Yegor Kuznetsov
//
// This is the driver class for the new BankAccount class. It creates
// many bank accounts using a file, does some stuff to them, and writes
// their final values to a file.

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Container;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class U7A2 extends JFrame
{
    private ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();
    JTextArea out = new JTextArea();

    public static void main(String[] args)
    {
        U7A2 u7a2 = new U7A2();
        u7a2.setSize(500, 500);
        u7a2.setVisible(true);
        u7a2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public U7A2()
    {
        BuildList();
        PrintList();

        Deposit("103s", 500);
        Withdraw("110s", 304.52);
        InsertNewAcct("105c", 300);
        DeleteDormantAccts();
        CorrectError("107s", 1113.88);
        ApplyInterest();
        InsertNewAcct("111s", 100);
        FileUpDated();
    }

    private void BuildList()
    {
        try
        {
            Scanner scanner = new Scanner(new File(
                    "U:\\STUDENT\\PROJECTS\\West Projects\\APCS\\myCreditUnion.txt"));

            while (scanner.hasNext())
            {
                StringTokenizer st = new StringTokenizer(scanner.nextLine());

                bankAccounts.add(new BankAccount(st.nextToken(),
                        Double.parseDouble(st.nextToken())));
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }

    private void PrintList()
    {
        out.append("Account#\tBalance\n");

        for (int i = 0; i < bankAccounts.size(); i++)
        {
            BankAccount account = bankAccounts.get(i);

            out.append(String.format(account.getAccountNumber()
                    + "\t$ %.2f\n", account.getBalance()));
        }

        out.append("\n");

        Container container = getContentPane();
        container.add(out);
    }

    private void Deposit(String accountNum, double amount)
    {
        int i = 0;
        for (; i < bankAccounts.size(); i++)
        {
            if (bankAccounts.get(i).getAccountNumber().equals(accountNum))
                break;
        }

        out.append(bankAccounts.get(i).deposit(amount) + "\n");
    }

    private void Withdraw (String accountNum, double amount)
    {
        int i = 0;
        for (; i < bankAccounts.size(); i++)
        {
            if (bankAccounts.get(i).getAccountNumber().equals(accountNum))
                break;
        }

        out.append(bankAccounts.get(i).withdraw(amount) + "\n");
    }

    private void InsertNewAcct(String accountNum, double initDep)
    {
        BankAccount account = new BankAccount(accountNum, initDep);

        String type = account.getAccountType();

        if (type.equals("c"))
        {
            int i = 0;
            for (; i < bankAccounts.size(); i++)
            {
                if (bankAccounts.get(i)
                        .getAccountNumber()
                        .equals(accountNum.substring(0, 3) + "s"))
                    break;
            }
            bankAccounts.add(i + 1, account);
        }
        else
        {
            bankAccounts.add(account);
        }

        out.append("New Account Added\n");
    }

    private void DeleteDormantAccts()
    {
        int c = 0;
        for (int i = 0; i < bankAccounts.size(); i++) {
            if (bankAccounts.get(i).getBalance() == 0)
            {
                bankAccounts.remove(i);
                c++;
            }
        }
        out.append(c + " Account(s) Removed\n");
    }

    private void CorrectError(String accountNum, double balance)
    {
        int i = 0;
        for (; i < bankAccounts.size(); i++)
        {
            if (bankAccounts.get(i).getAccountNumber().equals(accountNum))
                break;
        }

        bankAccounts.set(i, new BankAccount(accountNum, balance));
        out.append("Correction Completed\n");
    }

    private void ApplyInterest()
    {
        for (int i = 0; i < bankAccounts.size(); i++)
        {
            bankAccounts.get(i).calculate();
        }

        out.append("Interest Applied to all Savings Accounts\n");
    }

    private void FileUpDated()
    {
        try
        {
            FileWriter writer = new FileWriter("temp.txt");
            PrintWriter out = new PrintWriter(writer);

            for (int i = 0; i < bankAccounts.size(); i++)
            {
                BankAccount account = bankAccounts.get(i);

                out.println(account.getAccountNumber()
                        + String.format(" %.2f", account.getBalance()));
            }

            out.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }

        out.append("File Updated");
    }
}
