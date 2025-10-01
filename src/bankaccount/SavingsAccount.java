package bankaccount;
//Reviewed: All goods.
//Reviewer: Manuel John Dalacan

public class SavingsAccount extends AbstractBankAccount {
    /** The name of the account owner. */
    private String ownerName;
    /**
     * Creates a new SavingsAccount for the specified owner.
     *
     * @param owner the account owner's name
     */
    public SavingsAccount(final String owner) {
        super();
        this.ownerName = owner;
    }
    /**
     * Returns the name of the account owner.
     *
     * @return the owner name
     */
    public String getOwnerName() {
        return ownerName;
    }
    /**
     * Main method to test SavingsAccount functionality.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        int p1000 = 1000;
        int p500 = 500;
        int np500 = -500;
        int p1500 = 1500;
        int p100 = 100;
        int np100 = -100;
        int p11500 = 11500;
        //Test 1: Create savings account
        SavingsAccount acc = new SavingsAccount("Bilog");
        System.out.println("Account name: " + acc.ownerName);
        //Test 2: Deposit with valid amount
        try {
            acc.deposit(p1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 3: Deposit with zero amount
        try {
            acc.deposit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 4: Deposit with negative amount
        try {
            acc.deposit(np500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 5: Withdraw with sufficient funds
        try {
            acc.withdraw(p500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 6: Withdraw with insufficient funds
        try {
            acc.withdraw(p1500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 7: Withdraw with negative amount
        try {
            acc.withdraw(np100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 8: Deposit when account is frozen
        try {
            acc.freezeAccount();
            acc.deposit(p11500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 9: Withdraw when account is frozen
        try {
            acc.withdraw(p500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 10: Unfreeze account and withdraw
        try {
            acc.unfreezeAccount();
            acc.withdraw(p100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Test 11: Check account is frozen
        System.out.println(acc.isFrozen());
        //Test 12: Check balance after multiple transactions
        System.out.println("Balance: Php " + acc.getBalance());
    }

}
