package com.mybank.service;

import com.mybank.dto.request.CityRequest;
import com.mybank.dto.response.CityResponse;
import com.mybank.entity.City;

import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface CityService {

     CityResponse save(CityRequest cityRequest);
     CityResponse update(Long id,CityRequest cityRequest);
     void delete(Long id);
     List<CityResponse> getAll();
     CityResponse getOne(Long id);

     List<CityResponse> getAllOfCountry(CityRequest cityRequest);

}
