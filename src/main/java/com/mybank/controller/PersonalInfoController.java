package com.mybank.controller;

import com.mybank.dto.request.PersonalInfoRequest;
import com.mybank.dto.response.PersonalInfoResponse;
import com.mybank.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personalInfo")
@CrossOrigin
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @PutMapping("/{id}")
    public PersonalInfoResponse update(@PathVariable Long id,@RequestBody PersonalInfoRequest personalInfoRequest){
        return personalInfoService.update(id,personalInfoRequest);
    }

    @GetMapping("/{id}")
    public PersonalInfoResponse getOne(@PathVariable Long id){
        return personalInfoService.getOne(id);
    }

    @GetMapping
    public List<PersonalInfoResponse> getAll(){
        return  personalInfoService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personalInfoService.delete(id);
    }

}
