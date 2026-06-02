class GoodBankAccount
{
    private int balance;

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int amount)
    {
        if(amount >= 0)
        {
            balance += amount;
        }
    }
}