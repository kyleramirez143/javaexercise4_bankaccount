package bankaccount;
//Reviewed: All goods.
//Reviewer: Manuel John Dalacan

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

    /** SavingsAccount instance for testing purposes. */
    private SavingsAccount account;
    /** Constant for Php 1000. */
    private static final int P_1000 = 1000;
    /** Constant for Php 500. */
    private static final int P_500 = 500;
    /** Constant for negative Php 500. */
    private static final int NP_500 = -500;
    /** Constant for Php 1500. */
    private static final int P_1500 = 1500;
    /** Constant for Php 100. */
    private static final int P_100 = 100;
    /** Constant for negative Php 100. */
    private static final int NP_100 = -100;
    /** Constant for Php 11500. */
    private static final int P_11500 = 11500;
    /** Constant for Php 900. */
    private static final int P_900 = 900;
    /** Constant for Php 600. */
    private static final int P_600 = 600;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount("Bilog");
    }

    @DisplayName("Test account creation")
    @Test
    void testOwnerName() {
        assertEquals("Bilog", account.getOwnerName());
    }

    @DisplayName("Test amount deposit")
    @Test
    void testDepositValidAmount() throws Exception {
        account.deposit(P_1000);
        assertEquals(P_1000, account.getBalance());
    }

    @DisplayName("Test invalid amount deposit (zero)")
    @Test
    void testDepositZeroAmountThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> account
                .deposit(0));
        assertEquals("The deposit amount must be positive.", exception
                .getMessage());
    }

    @DisplayName("Test invalid amount deposit (negative)")
    @Test
    void testDepositNegativeAmountThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> account
                .deposit(NP_500));
        assertEquals("The deposit amount must be positive.", exception
                .getMessage());
    }

    @DisplayName("Test withdraw suffiencient funds")
    @Test
    void testWithdrawWithSufficientFunds() throws Exception {
        account.deposit(P_1000);
        account.withdraw(P_500);
        assertEquals(P_500, account.getBalance());
    }

    @DisplayName("Test withdraw insuffiencient funds")
    @Test
    void testWithdrawWithInsufficientFundsThrowsException() throws Exception {
        account.deposit(P_1000);
        Exception exception = assertThrows(Exception.class, () -> account
                .withdraw(P_1500));
        assertEquals("Insufficient balance.", exception.getMessage());
    }

    @DisplayName("Test withdraw invalid amount")
    @Test
    void testWithdrawNegativeAmountThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> account
                .withdraw(NP_100));
        assertEquals("The withdraw amount must be positive.", exception
                .getMessage());
    }

    @DisplayName("Test deposit when account is frozen")
    @Test
    void testDepositWhenFrozenThrowsException() throws Exception {
        account.freezeAccount();
        Exception exception = assertThrows(Exception.class, () -> account
                .deposit(P_11500));
        assertEquals("Account is frozen. Cannot deposit.", exception
                .getMessage());
    }

    @DisplayName("Test withdraw when account is frozen")
    @Test
    void testWithdrawWhenFrozenThrowsException() throws Exception {
        account.deposit(P_1000);
        account.freezeAccount();
        Exception exception = assertThrows(Exception.class, () -> account
                .withdraw(P_500));
        assertEquals("Account is frozen. Cannot withdraw.", exception
                .getMessage());
    }

    @DisplayName("Test unfreeze and withdraw")
    @Test
    void testUnfreezeAndWithdraw() throws Exception {
        account.deposit(P_1000);
        account.freezeAccount();
        account.unfreezeAccount();
        account.withdraw(P_100);
        assertEquals(P_900, account.getBalance());
    }

    @DisplayName("Test freeze and unfreeze account")
    @Test
    void testFreezeAndUnfreezeAccount() {
        account.freezeAccount();
        assertTrue(account.isFrozen());
        account.unfreezeAccount();
        assertFalse(account.isFrozen());
    }

    @DisplayName("Test balance after multiple transactions")
    @Test
    void testBalanceAfterMultipleTransactions() throws Exception {
        account.deposit(P_1000);
        account.withdraw(P_500);
        account.deposit(P_100);
        assertEquals(P_600, account.getBalance());
    }
}

