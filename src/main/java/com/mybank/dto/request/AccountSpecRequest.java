package com.mybank.dto.request;

import com.mybank.entity.State;

public class AccountSpecRequest {

    private double balance;

    private double balanceLess;

    private String cardNumber;

    private State state;

    private String accountType;

    private MyPageRequest myPageRequest;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalanceLess() {
        return balanceLess;
    }

    public void setBalanceLess(double balanceLess) {
        this.balanceLess = balanceLess;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public MyPageRequest getMyPageRequest() {
        return myPageRequest;
    }

    public void setMyPageRequest(MyPageRequest myPageRequest) {
        this.myPageRequest = myPageRequest;
    }
}
