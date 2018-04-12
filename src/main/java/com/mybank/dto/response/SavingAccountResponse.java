package com.mybank.dto.response;

import com.mybank.entity.SavingAccount;

public class SavingAccountResponse {

    private Long id;

    private Integer interestedRate;

    private AccountResponse accountResponse;

    public SavingAccountResponse(SavingAccount savingAccount) {
        this.id = savingAccount.getId();
        this.interestedRate = savingAccount.getInterestedRate();
        this.accountResponse = new AccountResponse(savingAccount.getAccount());
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
