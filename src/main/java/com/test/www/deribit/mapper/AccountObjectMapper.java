package com.test.www.deribit.mapper;

import com.test.www.deribit.domain.accountSummary.Account;
import com.test.www.deribit.domain.accountSummary.Result;

public class AccountObjectMapper {
    public static Account createAccountFromResult(Result result){
        Account account = new Account();
        account.accountId = result.id;
        account.currency = result.currency;
        account.available_funds = result.available_funds;
        account.available_withdrawal_funds = result.available_withdrawal_funds;
        account.balance = result.balance;
        account.deposit_address = result.deposit_address;
        account.email = result.email;
        account.username = result.username;
        return account;
    }
}
