package com.mybank.controller;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.CreditAccountRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.CreditAccountResponse;
import com.mybank.entity.CreditAccount;
import com.mybank.service.CreditAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditaccount")
@CrossOrigin
public class CreditAccountController {

    @Autowired
    private CreditAccountService creditAccountService;

    @PostMapping
    public CreditAccountResponse save(@RequestBody CreditAccountRequest creditAccountRequest){
        return creditAccountService.save(creditAccountRequest);
    }

    @PutMapping("/{id}")
    public CreditAccountResponse update(@PathVariable Long id,@RequestBody CreditAccountRequest creditAccountRequest){
        return creditAccountService.update(id,creditAccountRequest);
    }
    @PostMapping("/filter")
    public Page<CreditAccountResponse> filter(@RequestBody AccountSpecRequest accountSpecRequest){
        return creditAccountService.filter(accountSpecRequest);
    }

    @GetMapping("/{id}")
    public CreditAccountResponse getOne(@PathVariable Long id){
        return creditAccountService.getOne(id);
    }

    @GetMapping("/byclient/{id}")
    public List<CreditAccountResponse> getAllByClient(@PathVariable Long id){
        return creditAccountService.findAllByClient(id);
    }

    @PostMapping("/page")
    public Page<CreditAccountResponse> getAll(@RequestBody MyPageRequest myPageRequest){
        return creditAccountService.getAll(myPageRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        creditAccountService.delete(id);
    }

}
