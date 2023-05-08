package com.example.account.repository;

import com.example.account.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class AccountRepository {

    public Account getAccount(Long id) {
        return new Account(id, 0, new ArrayList<>());
    }
}
