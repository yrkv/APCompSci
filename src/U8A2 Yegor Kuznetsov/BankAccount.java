// Yegor Kuznetsov
//
// The BankAccount class manages... bank accounts! It stores
// their balance and has a number of methods to move around money.
// It also implements an interface to send data.
// The data is only used if the balance > 1000.

public class BankAccount implements Measurable
{
    private String accountNumber;
    private double balance;
    private String accountType;
    private static final double INTEREST_RATE = 1.04;

    public BankAccount(String accountNumber, double balance)
    {
        this.balance = balance;
        this.accountNumber = accountNumber;
        setAccountNumber(accountNumber);
    }

    private void setAccountNumber(String account)
    {
        accountType = account.substring(account.length() - 1, account.length());
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
        if (accountType.equals("s"))
            balance *= INTEREST_RATE;
        return balance;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getMeasure()
    {
        return balance;
    }

    public static double getInterestRate()
    {
        return INTEREST_RATE * 100 - 100;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public static String transfer(BankAccount a, BankAccount b, double amount)
    {
        String withdraw = a.withdraw(amount);
        if (withdraw.equals("Withdrawal Accepted"))
            return withdraw + "\n" + b.deposit(amount);
        else
            return withdraw + "\nDeposit Rejected";
    }

    public boolean accept()
    {
        return balance > 1000;
    }
}
