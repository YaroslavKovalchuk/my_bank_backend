package com.mybank.dto.response;

import com.mybank.entity.Client;

public class ClientResponse {

    private Long id;

    private String email;

    private PersonalInfoResponse personalInfoResponse;

    public ClientResponse(Client client) {
        this.id = client.getId();
        this.email = client.getEmail();
        this.personalInfoResponse = new PersonalInfoResponse(client.getPersonalInfo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonalInfoResponse getPersonalInfoResponse() {
        return personalInfoResponse;
    }

    public void setPersonalInfoResponse(PersonalInfoResponse personalInfoResponse) {
        this.personalInfoResponse = personalInfoResponse;
    }
}
