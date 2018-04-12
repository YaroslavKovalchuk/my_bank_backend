package com.mybank.controller;


import com.mybank.dto.request.CityRequest;
import com.mybank.dto.response.CityResponse;
import com.mybank.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/public/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/all")
    public CityResponse save(@RequestBody @Valid CityRequest cityRequest){
        return cityService.save(cityRequest);
    }

    @PostMapping
    public List<CityResponse> getAll(@RequestBody  CityRequest cityRequest){
        return cityService.getAllOfCountry(cityRequest);
    }

    @GetMapping("/{id}")
    public CityResponse getOne(@PathVariable Long id){
        return cityService.getOne(id);
    }

    @PutMapping("/{id}")
    public CityResponse update(@PathVariable Long id,@RequestBody CityRequest cityRequest){
        return cityService.update(id,cityRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        cityService.delete(id);
    }
}

