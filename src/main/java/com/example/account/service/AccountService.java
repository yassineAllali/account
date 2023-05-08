package com.example.account.service;

import com.example.account.entity.Account;
import com.example.account.entity.Operation;
import com.example.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(Long id) {
        return accountRepository.getAccount(id);
    }

    public Account deposit(Long id, double amount) {
        Account account = accountRepository.getAccount(id);
        deposit(account, amount);
        return account;
    }

    public void deposit(Account account, double amount) {
        double lastBalance = account.getBalance();
        account.setBalance(lastBalance + amount);
        addOperation(account, Operation.OperationType.DEPOSIT, amount);
    }

    public Account withdraw(Long id, double amount) {
        Account account = accountRepository.getAccount(id);
        withdraw(account, amount);
        return account;
    }

    public void withdraw(Account account, double amount) {
        if(amount <= account.getBalance()) {
            double lastBalance = account.getBalance();
            account.setBalance(lastBalance - amount);
            addOperation(account, Operation.OperationType.WITHDRAW, amount);
        }
        else {
            throw new BalanceException("Balance not enough for withdrawal!");
        }

    }

    private void addOperation(Account account, Operation.OperationType type, double amount) {
        Operation operation = new Operation(type, LocalDateTime.now(), amount);
        account.addOperation(operation);
    }
}
