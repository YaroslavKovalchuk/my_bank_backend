package com.mybank.dto.response;

import com.mybank.entity.Support;

import java.util.Date;

public class SupportResponse {

    private Long id;

    private String messageContain;

    private Date messageDate;

    private ClientResponse clientResponse;

    public SupportResponse(Support support) {
        this.id = support.getId();
        this.messageContain = support.getMessageContain();
        this.messageDate = support.getMessageDate();
        this.clientResponse = new ClientResponse(support.getClient());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ClientResponse getClientResponse() {
        return clientResponse;
    }

    public void setClientResponse(ClientResponse clientResponse) {
        this.clientResponse = clientResponse;
    }
}
