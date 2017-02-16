// Yegor Kuznetsov
//
// The BankAccount_Old class manages... bank accounts! It store
// their balance and has a number of methods to move around money

public class BankAccount_Old
{
    private int accountNumber;
    private double balance;
    private static int lastAssignedNum = 100;
    private static final double INTEREST_RATE = 1.04;

    public BankAccount_Old()
    {
        balance = Math.random() * 1000;
        lastAssignedNum++;
        accountNumber = lastAssignedNum;
    }

    public BankAccount_Old(double balance)
    {
        this.balance = balance;
        lastAssignedNum++;
        accountNumber = lastAssignedNum;
    }

    public String deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            return "Deposit Accepted";
        }  else
            return "Deposit Rejected";
    }

    public String withdraw(double amount)
    {
        if (amount <= balance)
        {
            balance -= amount;
            return "Withdrawal Accepted";
        }  else return "Withdrawal Denied - Insufficient Funds";
    }

    public double calculate()
    {
        balance *= INTEREST_RATE;
        return balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public static double getInterestRate()
    {
        return INTEREST_RATE * 100 - 100;
    }

    public static String transfer(BankAccount_Old a, BankAccount_Old b, double amount)
    {
        String withdraw = a.withdraw(amount);
        if (withdraw.equals("Withdrawal Accepted"))
            return withdraw + "\n" + b.deposit(amount);
        else
            return withdraw + "\nDeposit Rejected";
    }
}
