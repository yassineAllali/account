package com.example.account.controller;

import com.example.account.entity.Account;
import com.example.account.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam double amount) {
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam double amount) {
        return accountService.withdraw(id, amount);
    }

    @GetMapping("/{id}/history")
    public Account history(@PathVariable Long id) {
        return accountService.getAccount(id);
    }
}
