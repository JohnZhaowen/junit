package com.john.test.junit.service;

import com.john.test.junit.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountQuerySericeImpl implements AccountQuerySerice {

    @Override
    public List<Account> queryAll() {

        List<Account> r = new ArrayList<>(4);

        Account account1 = new Account("1aer123", "测试产品1", 1, 1);
        Account account2 = new Account("1aer234", "测试产品2", 11, 0);
        Account account3 = new Account("1aer456", "测试产品3", 111, 0);
        Account account4 = new Account("1aer567", "测试产品4", 1111, 1);
        r.add(account1);
        r.add(account2);
        r.add(account3);
        r.add(account4);

        return r;
    }
}
