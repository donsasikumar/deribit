package com.test.www.deribit.service;

import com.test.www.deribit.domain.accountSummary.Account;
import com.test.www.deribit.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account getAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    public void saveOrUpdate(Account account) {
        accountRepository.save(account);
    }

    public void delete(int id) {
        accountRepository.deleteById(id);
    }
}
