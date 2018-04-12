package com.mybank.service.impl;

import com.mybank.dto.request.CityRequest;
import com.mybank.dto.response.CityResponse;
import com.mybank.entity.City;
import com.mybank.repository.CityRepository;
import com.mybank.repository.CountryRepository;
import com.mybank.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class CityServiceImpl implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CityResponse save(CityRequest cityRequest) {
        City city = new City();
        city.setName(cityRequest.getName());
        city.setCountry(countryRepository.findCountryByName(cityRequest.getIdCountry()));
        return new CityResponse(cityRepository.save(city));
    }

    @Override
    public CityResponse update(Long id, CityRequest cityRequest) {
        City city = cityRepository.findOne(id);
        city.setName(cityRequest.getName());
        city.setCountry(countryRepository.findCountryByName(cityRequest.getIdCountry()));
        return new CityResponse(cityRepository.save(city));
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public List<CityResponse> getAll() {
        List<City> cityList = cityRepository.findAll();
        List<CityResponse> cityResponseList = new ArrayList<>();
        for (City city:cityList){
            cityResponseList.add(new CityResponse(city));
        }
        return cityResponseList;
    }

    @Override
    public CityResponse getOne(Long id) {
        return new CityResponse(cityRepository.findOne(id));
    }

    @Override
    public List<CityResponse> getAllOfCountry(CityRequest cityRequest) {
        List<City> cityList = cityRepository.findAllByCountryName(cityRequest.getIdCountry());
        List<CityResponse> cityResponseList = new ArrayList<>();
        for (City city:cityList){
            cityResponseList.add(new CityResponse(city));
        }
        return cityResponseList;
    }
}
