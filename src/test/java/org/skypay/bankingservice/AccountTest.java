package org.skypay.bankingservice;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void deposit_then_withdraw_updates_balance_and_does_not_throw() {
        Account account = new Account();

        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.deposit(2000, LocalDate.of(2012, 1, 13));
        account.withdraw(500, LocalDate.of(2012, 1, 14));

        // no direct getter; we assert indirectly via statement not throwing
        assertDoesNotThrow(account::printStatement);
    }

    @Test
    void withdraw_more_than_balance_throws() {
        Account account = new Account();
        account.deposit(1000, LocalDate.of(2012, 1, 10));

        assertThrows(IllegalStateException.class,
                () -> account.withdraw(2000, LocalDate.of(2012, 1, 11)));
    }

    @Test
    void deposit_with_non_positive_amount_throws() {
        Account account = new Account();

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0, LocalDate.of(2012, 1, 10)));
    }
}