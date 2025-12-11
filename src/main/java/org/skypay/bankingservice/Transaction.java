package org.skypay.bankingservice;


import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private final int amount; // + for deposit, - for withdrawal

    public Transaction(LocalDate date, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("date cannot be null");
        }
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }
}

