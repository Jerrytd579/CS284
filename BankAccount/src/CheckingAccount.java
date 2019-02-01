public class CheckingAccount extends BankAccount {
    // Data fields
    private int transactions;

    // Constructor
    CheckingAccount(double initialBalance) {
        super(initalBalance);
        transactions = 0;
    }

    // Methods
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactions++;
    }

}
