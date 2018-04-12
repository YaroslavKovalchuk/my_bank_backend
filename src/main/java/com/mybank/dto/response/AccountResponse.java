package com.mybank.dto.response;

import com.mybank.entity.Account;
import com.mybank.entity.State;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AccountResponse {

    private Long id;

    private double balance;

    private String cardNumber;

    private Date date;

    private State state;

    private ClientResponse clientResponse;


    public AccountResponse(Account account) {
        this.id = account.getId();
        this.balance = account.getBalance();
        this.cardNumber = account.getCardNumber();
        this.date = account.getDate();
        this.state = account.isState();
        this.clientResponse = new ClientResponse(account.getClient());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ClientResponse getClientResponse() {
        return clientResponse;
    }

    public void setClientResponse(ClientResponse clientResponse) {
        this.clientResponse = clientResponse;
    }

}
