package com.test.www.deribit.controller;

import com.test.www.deribit.mapper.AccountObjectMapper;
import com.test.www.deribit.domain.accountSummary.Account;
import com.test.www.deribit.domain.accountSummary.Result;
import com.test.www.deribit.response.*;
import com.test.www.deribit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExchangeRestController {
    public static final String EXCHANGE_URL = "https://test.deribit.com/api/v2/private";

    @Autowired
    AccountService accountService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get_account_summary")
    public ResponseEntity<AccountSummaryResponse> getAccountSummary(@RequestParam("currency") String currency,
                                                                    @RequestParam("extended") boolean extended) {
        AccountSummaryResponse response = restTemplate.getForObject(
                EXCHANGE_URL + "/get_account_summary" + "?currency=" + currency + "&extended=" + extended, AccountSummaryResponse.class);
        ResponseEntity<AccountSummaryResponse> accountSummaryResponse = new ResponseEntity<>(response, HttpStatus.ACCEPTED.OK);
        if (accountSummaryResponse != null && accountSummaryResponse.getBody() != null && accountSummaryResponse.getBody().result != null) {
            Account accountFromResult = AccountObjectMapper.createAccountFromResult(accountSummaryResponse.getBody().result);
            accountService.saveOrUpdate(accountFromResult);
        }
        return accountSummaryResponse;

    }

    @GetMapping("/get_deposits")
    public ResponseEntity<DepositHistoryResponse> getDeposits(@RequestParam int count,
                                                              @RequestParam String currency,
                                                              @RequestParam int offset) {
        DepositHistoryResponse response = restTemplate.getForObject(
                EXCHANGE_URL + "/get_deposits" + "?count" + count + "&currency=" + currency + "&offset=" + offset, DepositHistoryResponse.class);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED.OK);
    }

    @GetMapping("/get_withdrawals")
    public ResponseEntity<WithDrawalHistoryResponse> getWithdrawals(@RequestParam int count,
                                                                    @RequestParam String currency,
                                                                    @RequestParam int offset) {
        WithDrawalHistoryResponse response = restTemplate.getForObject(
                EXCHANGE_URL + "/get_withdrawals" + "?count" + count + "&currency=" + currency + "&offset=" + offset, WithDrawalHistoryResponse.class);
        return new ResponseEntity<>(new WithDrawalHistoryResponse(), HttpStatus.ACCEPTED.OK);
    }

    @GetMapping("/withdraw")
    public ResponseEntity<WithDrawResponse> withdraw(@RequestParam String address,
                                                     @RequestParam float amount,
                                                     @RequestParam String currency,
                                                     @RequestParam String priority) {
        WithDrawResponse response = restTemplate.getForObject(
                EXCHANGE_URL + "/withdraw" + "?address" + address + "&amount=" + amount + "&currency=" + currency + "&priority=" + priority, WithDrawResponse.class);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED.OK);
    }

    @GetMapping("/submit_transfer_to_subaccount")
    public ResponseEntity<TransferResponse> transferToSubAccount(
            @RequestParam float amount,
            @RequestParam String currency,
            @RequestParam int destination) {
        TransferResponse response = restTemplate.getForObject(
                EXCHANGE_URL + "/submit_transfer_to_subaccount" + "?amount=" + amount + "&currency=" + currency + "&destination=" + destination, TransferResponse.class);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED.OK);
    }
}
