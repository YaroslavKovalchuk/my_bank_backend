package com.mybank.dto.response;

import com.mybank.entity.Account;
import com.mybank.entity.MoneyTransfer;

import java.util.Date;
import java.util.List;

public class MoneyTransferResponse {

    private Long id;

    private Long amount;

    private Date dateTransfer;

    private AccountResponse sender;

    private AccountResponse resiver;

    public MoneyTransferResponse(MoneyTransfer moneyTransfer) {
        this.id = moneyTransfer.getId();
        this.amount = moneyTransfer.getAmount();
        this.dateTransfer = moneyTransfer.getDateTransfer();
        this.sender = new AccountResponse(moneyTransfer.getSender());
        this.resiver = new AccountResponse(moneyTransfer.getResiver());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    public AccountResponse getSender() {
        return sender;
    }

    public void setSender(AccountResponse sender) {
        this.sender = sender;
    }

    public AccountResponse getResiver() {
        return resiver;
    }

    public void setResiver(AccountResponse resiver) {
        this.resiver = resiver;
    }
}
