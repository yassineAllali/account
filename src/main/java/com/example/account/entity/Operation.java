package com.example.account.entity;

import java.time.LocalDateTime;

public class Operation {

    private OperationType type;
    private LocalDateTime dateTime;
    private double amount;

    public Operation() {
    }

    public Operation(OperationType type, LocalDateTime dateTime, double amount) {
        this.type = type;
        this.dateTime = dateTime;
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public enum OperationType {
        DEPOSIT,
        WITHDRAW
    }
}
