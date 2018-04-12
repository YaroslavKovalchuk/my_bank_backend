package com.mybank.dto.response;

import com.mybank.entity.Account;
import com.mybank.entity.CreditAccount;

public class CreditAccountResponse {

    private Long id;

    private Integer interestedRate;

    private AccountResponse accountResponse;

    public CreditAccountResponse(CreditAccount creditAccount) {
        this.id = creditAccount.getId();
        this.interestedRate = creditAccount.getInterestedRate();
        this.accountResponse = new AccountResponse(creditAccount.getAccount());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(Integer interestedRate) {
        this.interestedRate = interestedRate;
    }

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(AccountResponse accountResponse) {
        this.accountResponse = accountResponse;
    }
}
