package com.mybank.dto.request;

import javax.validation.constraints.NotNull;

public class CurrentAccountRequest {

    @NotNull
    private Long account_id;

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
    }
}
