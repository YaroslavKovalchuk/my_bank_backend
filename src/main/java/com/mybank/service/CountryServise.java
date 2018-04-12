package com.mybank.service;

import com.mybank.dto.request.CountryRequest;
import com.mybank.dto.response.CountryResponse;
import com.mybank.dto.response.PersonalInfoResponse;
import com.mybank.entity.Country;
import com.mybank.entity.PersonalInfo;

import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface CountryServise {

    CountryResponse save(CountryRequest countryRequest);
    CountryResponse update(Long id,CountryRequest countryRequest);
    void delete(Long id);
    List<CountryResponse> getAll();
    CountryResponse getOne(Long id);

}
