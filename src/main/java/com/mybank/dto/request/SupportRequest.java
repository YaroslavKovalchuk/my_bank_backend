package com.mybank.dto.request;

import com.mybank.entity.Client;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class SupportRequest {

    @NotNull
    private String messageContain;

    private Date messageDate;

    @NotNull
    private Long client_id;

    public String getMessageContain() {
        return messageContain;
    }

    public void setMessageContain(String messageContain) {
        this.messageContain = messageContain;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }
}
