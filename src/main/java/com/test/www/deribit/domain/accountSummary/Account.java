package com.test.www.deribit.domain.accountSummary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    public int accountId;
    public String deposit_address;
    private Long id;
    public double available_funds;
    public String username;
    public String currency;
    public double available_withdrawal_funds;
    public String email;
    public double balance;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getDeposit_address() {
        return deposit_address;
    }

    public void setDeposit_address(String deposit_address) {
        this.deposit_address = deposit_address;
    }

    public double getAvailable_funds() {
        return available_funds;
    }

    public void setAvailable_funds(double available_funds) {
        this.available_funds = available_funds;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAvailable_withdrawal_funds() {
        return available_withdrawal_funds;
    }

    public void setAvailable_withdrawal_funds(double available_withdrawal_funds) {
        this.available_withdrawal_funds = available_withdrawal_funds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
