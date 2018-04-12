package com.mybank.dto.response;

import com.mybank.entity.BankAccount;

public class BankAccountResponse {

    private Long id;

    private AccountResponse accountResponse;

    public BankAccountResponse(BankAccount bankAccount) {
        this.id = bankAccount.getId();
        this.accountResponse = new AccountResponse(bankAccount.getAccount());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountResponse getAccountResponse() {
        return accountResponse;
    }

    public void setAccountResponse(AccountResponse accountResponse) {
        this.accountResponse = accountResponse;
    }
}
