package com.mybank.dto.response;

import com.mybank.entity.CurrentAccount;

public class CurrentAccountResponse {

    private Long id;

    private AccountResponse accountResponse;

    public CurrentAccountResponse(CurrentAccount currentAccount) {
        this.id = currentAccount.getId();
        this.accountResponse = new AccountResponse(currentAccount.getAccount());
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
