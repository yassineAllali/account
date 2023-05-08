package com.example.account.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Long id;
    private double balance;
    private List<Operation> operationsHistory;


    public Account() {
        id = 1l;
        balance = 0;
        operationsHistory = new ArrayList<>();
    }

    public Account(Long id, double balance, List<Operation> operationsHistory) {
        this.id = id;
        this.balance = balance;
        this.operationsHistory = operationsHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Operation> getOperationsHistory() {
        return operationsHistory;
    }

    public void setOperationsHistory(List<Operation> operationsHistory) {
        this.operationsHistory = operationsHistory;
    }

    public void addOperation(Operation operation) {
        this.operationsHistory.add(operation);
    }
}
