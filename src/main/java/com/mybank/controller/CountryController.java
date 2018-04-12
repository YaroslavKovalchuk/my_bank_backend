package com.mybank.controller;

import com.mybank.dto.request.CountryRequest;
import com.mybank.dto.response.CountryResponse;
import com.mybank.service.CountryServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/public/country")
@CrossOrigin
public class CountryController {

    @Autowired
    private CountryServise countryServise;

    @PostMapping
    public CountryResponse save(@RequestBody @Valid CountryRequest countryRequest){
        return countryServise.save(countryRequest);
    }

    @PutMapping("/{id}")
    public CountryResponse update(@PathVariable Long id,@RequestBody CountryRequest countryRequest){
        return countryServise.update(id,countryRequest);
    }

    @GetMapping
    public List<CountryResponse> getAll(){
        return countryServise.getAll();
    }

    @GetMapping("/{id}")
    public CountryResponse getOne(@PathVariable Long id){
        return countryServise.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        countryServise.delete(id);
    }

}
