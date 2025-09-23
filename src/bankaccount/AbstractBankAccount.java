package bankaccount;

public abstract class AbstractBankAccount implements BankAccount {
    /** The current balance of the account. */
    private double balance;
    /** Indicates whether the account is frozen or active. */
    private boolean isFrozen;

    /**
     * Constructs a bank account with an initial balance and frozen status.
     *
     * @param accBalance the initial balance of the account
     * @param accIsFrozen the initial frozen status of the account
     */
    public AbstractBankAccount(final double accBalance,
            final boolean accIsFrozen) {
        this.balance = accBalance;
        this.isFrozen = accIsFrozen;
    }

    /**
     * Constructs a bank account with a zero balance and active status.
     */
    public AbstractBankAccount() {
        this.balance = 0.0;
        this.isFrozen = false;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount to deposit
     * @throws Exception if the account is frozen or the amount is not positive
     */
    public void deposit(final double amount) throws Exception {
        if (isFrozen) {
            throw new Exception("Account is frozen. Cannot deposit.");
        }
        if (amount <= 0) {
            throw new Exception("The deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: Php " + amount);
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount to withdraw
     * @throws Exception if the account is frozen, amount is invalid, or
     * insufficient balance
     */
    public void withdraw(final double amount) throws Exception {
        if (isFrozen) {
            throw new Exception("Account is frozen. Cannot withdraw.");
        }
        if (amount <= 0) {
            throw new Exception("The withdraw amount must be positive.");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawn: Php " + amount);
    }
    /** Balance getter.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    /** Acc status getter.
     * @return isFrozen
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     * Freezes the account.
     */
    public void freezeAccount() {
        this.isFrozen = true;
        System.out.println("Account has been frozen.");
    }

    /**
     * Unfreezes the account.
     */
    public void unfreezeAccount() {
        this.isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }

}
