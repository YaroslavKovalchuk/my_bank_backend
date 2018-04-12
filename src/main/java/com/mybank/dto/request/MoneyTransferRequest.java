package com.mybank.dto.request;

import com.mybank.entity.Account;


import javax.validation.constraints.NotNull;
import java.util.Date;

public class MoneyTransferRequest {

    private Long sender_id;

    private Long amount;

    private Date dateTransfer;

    @NotNull
    private String  resiverCardNumber;

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

    public String getresiverCardNumber() {
        return resiverCardNumber;
    }

    public void setresiverCardNumber(String resiver_id) {
        this.resiverCardNumber = resiver_id;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }
}
