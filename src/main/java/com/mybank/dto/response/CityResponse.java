package com.mybank.dto.response;

import com.mybank.entity.City;

public class CityResponse {

    private Long id;

    private String name;

    private CountryResponse countryResponse;

    public CityResponse(City city) {

        this.id = city.getId();
        this.name = city.getName();
        this.countryResponse = new CountryResponse(city.getCountry());

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

    public CountryResponse getCountryResponse() {
        return countryResponse;
    }

    public void setCountryResponse(CountryResponse countryResponse) {
        this.countryResponse = countryResponse;
    }
}
