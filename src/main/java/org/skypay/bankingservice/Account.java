package org.skypay.bankingservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {

    private static final DateTimeFormatter STATEMENT_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount, LocalDate date) {
        validateAmount(amount);
        validateDate(date);

        balance += amount;
        transactions.add(new Transaction(date, amount));
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        validateAmount(amount);
        validateDate(date);

        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance -= amount;
        transactions.add(new Transaction(date, -amount));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE       || AMOUNT || BALANCE");

        int runningBalance = balance;

        List<Transaction> copy = new ArrayList<>(transactions);
        Collections.reverse(copy); // latest first

        for (Transaction tx : copy) {

            String dateStr = tx.getDate().format(STATEMENT_DATE_FORMATTER);
            int amount = tx.getAmount();

            System.out.printf("%s || %6d || %7d%n", dateStr, amount, runningBalance);
            runningBalance -= amount;
        }
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }
    }

    private static void validateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("date cannot be null");
        }
    }
}

