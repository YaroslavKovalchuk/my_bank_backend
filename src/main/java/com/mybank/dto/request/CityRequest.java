package com.mybank.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CityRequest {

    @NotNull
    @Pattern(regexp = "(^[A-Z])[a-z]+")
    private String name;

    @NotNull
    private String idCountry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(String idCountry) {
        this.idCountry = idCountry;
    }
}
