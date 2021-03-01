package lab01.example.model;

public abstract class SimpleBankAccount implements BankAccount{
    protected double balance;
    protected final AccountHolder holder;

    public SimpleBankAccount(final AccountHolder holder, final double balance) {
        this.holder = holder;
        this.balance = balance;
    }
    @Override
    public AccountHolder getHolder(){
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    abstract public void deposit(final int usrID, final double amount);

    @Override
    abstract public void withdraw(final int usrID, final double amount);

    protected boolean isWithdrawAllowed(final double amount){
        return this.balance >= amount;
    }

    protected boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
