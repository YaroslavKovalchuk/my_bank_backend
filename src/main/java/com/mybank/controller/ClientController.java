package com.mybank.controller;


import com.mybank.dto.request.ClieantRequest;
import com.mybank.dto.request.LoginRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.ClientResponse;
import com.mybank.dto.response.TokenResponse;
import com.mybank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest){
        return clientService.login(loginRequest);
    }

    @GetMapping("/{id}")
    public ClientResponse getOne(@PathVariable Long  id){
        return clientService.getOne(id);
    }

    @GetMapping("/email")
    public Long getOneByEmail(@RequestParam String email){
        return clientService.getOneByEmail(email).longValue();
    }

    @PutMapping("/{id}")
    public  ClientResponse update(@PathVariable Long id,@RequestBody ClieantRequest clieantRequest){
        return clientService.update(id,clieantRequest);
    }

    @PostMapping("/page")
    public Page<ClientResponse> getAll(@RequestBody MyPageRequest myPageRequest){
        return clientService.getAll(myPageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }

}

