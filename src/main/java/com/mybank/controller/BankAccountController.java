package com.mybank.controller;

import com.mybank.dto.request.BankAccountRequest;
import com.mybank.dto.response.BankAccountResponse;
import com.mybank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankaccount")
@CrossOrigin
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public BankAccountResponse save(@RequestBody BankAccountRequest bankAccountRequest){
        return bankAccountService.save(bankAccountRequest);
    }

    @PutMapping("/{id}")
    public BankAccountResponse update(@PathVariable Long id,@RequestBody BankAccountRequest bankAccountRequest){
        return bankAccountService.update(id,bankAccountRequest);
    }

    @GetMapping("/{id}")
    public BankAccountResponse getOne(@PathVariable Long id){
        return bankAccountService.getOne(id);
    }

    @GetMapping
    public List<BankAccountResponse> getAll(){
        return bankAccountService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         bankAccountService.delete(id);
    }

}
