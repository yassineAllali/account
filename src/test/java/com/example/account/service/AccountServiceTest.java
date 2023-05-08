package com.example.account.service;

import com.example.account.entity.Account;
import com.example.account.entity.Operation;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        AccountRepository repository = new AccountRepository();
        accountService = new AccountService(repository);
    }

    @Test
    void testDeposit() {
        // GIVEN
        Operation operation = new Operation(Operation.OperationType.DEPOSIT,
                LocalDateTime.of(2023, Month.FEBRUARY, 12, 15, 30), 150);
        Account account = new Account(1l, 150, new ArrayList<Operation>(Arrays.asList(operation)));

        // WHEN
        accountService.deposit(account, 68);

        // THEN
        assertEquals(218, account.getBalance());
        assertEquals(2, account.getOperationsHistory().size());
    }

    @Test
    void testWithdraw() {
        // GIVEN
        Operation operation = new Operation(Operation.OperationType.DEPOSIT,
                LocalDateTime.of(2023, Month.FEBRUARY, 12, 15, 30), 150);
        Account account = new Account(1l, 150, new ArrayList<Operation>(Arrays.asList(operation)));

        // WHEN
        accountService.withdraw(account, 68);

        // THEN
        assertEquals(82, account.getBalance());
        assertEquals(2, account.getOperationsHistory().size());
    }

    @Test
    void testWithdrawShouldFailWhenBalanceIsNotEnough() {
        // GIVEN
        Operation operation = new Operation(Operation.OperationType.DEPOSIT,
                LocalDateTime.of(2023, Month.FEBRUARY, 12, 15, 30), 150);
        Account account = new Account(1l, 150, new ArrayList<Operation>(Arrays.asList(operation)));

        // WHEN

        // THEN
        assertThrows(BalanceException.class, () -> accountService.withdraw(account, 200));
    }

    @Test
    void testOperationsHistory() {
        // GIVEN
        Account account = new Account();

        // WHEN
        accountService.deposit(account, 70);

        // THEN
        assertEquals(70, account.getOperationsHistory().get(0).getAmount());
        assertEquals("DEPOSIT", account.getOperationsHistory().get(0).getType().toString());
        assertEquals(1, account.getOperationsHistory().size());
    }
}