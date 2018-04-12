package com.mybank.controller;

import com.mybank.dto.request.AccountRequest;
import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.AccountResponse;
import com.mybank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountResponse save(@RequestBody @Valid AccountRequest accountRequest){
        return accountService.save(accountRequest);
    }

    @PutMapping("/{id}")
    public AccountResponse update(@PathVariable Long id,@RequestBody AccountRequest accountRequest){
        return accountService.update(id,accountRequest);
    }

    @GetMapping("/{id}")
    public AccountResponse getOne(@PathVariable Long id){
        return accountService.getOne(id);
    }

    @PostMapping("/selectOne")
    public AccountResponse getOneByClientId(@RequestBody AccountRequest accountRequest){
        return accountService.findByClient(accountRequest);
    }

    @PostMapping("/filter")
    public Page<AccountResponse> filter(@RequestBody AccountSpecRequest accountSpecRequest){
        return accountService.filter(accountSpecRequest);
    }

    @GetMapping
    public List<AccountResponse> getAll(){
        return accountService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        accountService.delete(id);
    }


}
