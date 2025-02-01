package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.BankAccount;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(1000);
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance(), "Deposit failed!");
    }

    @Test
    void testWithdrawal() {
        assertTrue(account.withdraw(300), "Withdrawal should be successful!");
        assertEquals(700, account.getBalance(), "Balance after withdrawal is incorrect!");
    }

    @Test
    void testWithdrawalInsufficientFunds() {
        assertFalse(account.withdraw(2000), "Withdrawal should fail due to insufficient funds!");
        assertEquals(1000, account.getBalance(), "Balance should remain unchanged!");
    }

    @Test
    void testTransactionHistory() {
        account.deposit(200);
        account.withdraw(100);
        String history = account.getTransactionHistory();
        assertTrue(history.contains("Deposited: 200") && history.contains("Withdrawn: 100"),
            "Transaction history is incorrect!");
    }
}
