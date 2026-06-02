/* Hide the internal data of an object
and control how other code accesses it. */

public class Main extends GoodBankAccount //BadBankAccount
{
    public static void main(String[] args)
    {
        BadBankAccount bad = new BadBankAccount();

        bad.balance = 1000;
        bad.balance = -5000;

        System.out.println("Bad Account: " + bad.balance);

        GoodBankAccount good = new GoodBankAccount();

        good.setBalance(1000);

        // good.balance = 50000; // ERROR

        System.out.println("Good Account: " + good.getBalance());
    }
}