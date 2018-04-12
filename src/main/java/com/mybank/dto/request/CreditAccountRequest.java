package com.mybank.dto.request;

import javax.validation.constraints.NotNull;

public class CreditAccountRequest {

    @NotNull
    private Integer interestedRate;

    private double balance;

    @NotNull
    private Long account_id;

    public Integer getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(Integer interestedRate) {
        this.interestedRate = interestedRate;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
