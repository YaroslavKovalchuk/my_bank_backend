package com.mybank.dto.response;

import com.mybank.entity.Country;

public class CountryResponse {

    private Long id;

    private String name;

    public CountryResponse(Country country) {
        this.id = country.getId();
        this.name = country.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
