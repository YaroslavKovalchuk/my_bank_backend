package com.mybank.dto.request;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CountryRequest {

    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "(^[A-Z])[a-z]+")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
