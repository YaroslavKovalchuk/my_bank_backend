package com.mybank.controller;


import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.request.SavingAccountRequest;
import com.mybank.dto.response.SavingAccountResponse;
import com.mybank.entity.SavingAccount;
import com.mybank.service.impl.SavingAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saving")
@CrossOrigin
public class SavingAccountController {

    @Autowired
    private SavingAccountServiceImpl savingAccountService;

    @PostMapping
    public SavingAccountResponse save(@RequestBody SavingAccountRequest savingAccountRequest){
        return savingAccountService.save(savingAccountRequest);
    }

    @PutMapping("/{id}")
    public SavingAccountResponse update(@PathVariable Long id,@RequestBody SavingAccountRequest savingAccountRequest){
        return savingAccountService.update(id,savingAccountRequest);
    }

    @GetMapping("/{id}")
    public SavingAccountResponse getOne(@PathVariable Long id){
        return savingAccountService.getOne(id);
    }

    @GetMapping("/byclient/{id}")
    public List<SavingAccountResponse> getAllByClient(@PathVariable Long id){
        return savingAccountService.getAllByClient(id);
    }

    @PostMapping("/page")
    public Page<SavingAccountResponse> getAll(@RequestBody MyPageRequest myPageRequest){
        return savingAccountService.getAll(myPageRequest);
    }
    @PostMapping("/filter")
    public Page<SavingAccountResponse> filter(@RequestBody AccountSpecRequest accountSpecRequest){
        return savingAccountService.filter(accountSpecRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        savingAccountService.delete(id);
    }
}

