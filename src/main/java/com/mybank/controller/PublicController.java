package com.mybank.controller;

import com.mybank.dto.request.ClieantRequest;
import com.mybank.dto.request.LoginRequest;
import com.mybank.dto.request.PersonalInfoRequest;
import com.mybank.dto.response.ClientResponse;
import com.mybank.dto.response.PersonalInfoResponse;
import com.mybank.dto.response.TokenResponse;
import com.mybank.service.ClientService;
import com.mybank.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class PublicController {


    @Autowired
    private ClientService clientService;

    @Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest){
        return clientService.login(loginRequest);
    }

    @PostMapping("/createclient")
    public ClientResponse save(@RequestBody @Valid ClieantRequest clieantRequest){
        return clientService.save(clieantRequest);
    }
    @PostMapping("/createperson")
    public PersonalInfoResponse save(@RequestBody @Valid PersonalInfoRequest personalInfoRequest){
        return personalInfoService.save(personalInfoRequest);
    }
}
