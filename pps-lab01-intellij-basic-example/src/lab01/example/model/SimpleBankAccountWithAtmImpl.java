package lab01.example.model;

public class SimpleBankAccountWithAtmImpl extends SimpleBankAccount {
    private final Integer ATM=1;
    public SimpleBankAccountWithAtmImpl(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int usrID, final double amount) {
        if (checkUser(usrID) && fee()) {
            this.balance += amount-ATM;
        }
    }

    @Override
    public void withdraw(final int usrID, final double amount) {
        if (checkUser(usrID) && isWithdrawAllowed(amount) && fee()) {
            this.balance -= amount-ATM;
        }
    }

    private boolean fee(){
        return (this.balance=-(ATM))>0? true : false;
    }
}
