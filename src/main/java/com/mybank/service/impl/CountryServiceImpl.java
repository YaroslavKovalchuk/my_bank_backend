package com.mybank.service.impl;

import com.mybank.dto.request.CountryRequest;
import com.mybank.dto.response.CountryResponse;
import com.mybank.entity.Country;
import com.mybank.repository.CountryRepository;
import com.mybank.service.CountryServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class CountryServiceImpl  implements CountryServise {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryResponse save(CountryRequest countryRequest) {
        Country country = new Country();
        country.setName(countryRequest.getName());
        return new CountryResponse(countryRepository.save(country));
    }

    @Override
    public CountryResponse update(Long id, CountryRequest countryRequest) {
        Country country = countryRepository.findOne(id);
        country.setName(countryRequest.getName());
        return new CountryResponse(countryRepository.save(country));
    }

    @Override
    public void delete(Long id) {
        countryRepository.delete(id);
    }

    @Override
    public List<CountryResponse> getAll() {
        List<Country> countries = countryRepository.findAll();
        List<CountryResponse> countryResponseList = new ArrayList<>();
        for (Country country:countries){
            countryResponseList.add(new CountryResponse(country));
        }
        return countryResponseList;
    }

    @Override
    public CountryResponse getOne(Long id) {
        return new CountryResponse(countryRepository.findOne(id));
    }
}
