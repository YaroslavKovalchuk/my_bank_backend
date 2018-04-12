package com.mybank.dto.response;

public class TokenResponse {

    private String tokenBoody;

    public TokenResponse(String tokenBoody) {
        this.tokenBoody = "Bearer " + tokenBoody;
    }

    public String getTokenBoody() {
        return tokenBoody;
    }

    public void setTokenBoody(String tokenBoody) {
        this.tokenBoody = tokenBoody;
    }
}
