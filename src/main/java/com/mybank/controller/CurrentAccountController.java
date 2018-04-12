package com.mybank.controller;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.CurrentAccountRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.CurrentAccountResponse;
import com.mybank.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/currentaccount")
@CrossOrigin
public class CurrentAccountController {

    @Autowired
    private CurrentAccountService currentAccountService;

    @PostMapping
    public CurrentAccountResponse save(@RequestBody @Valid CurrentAccountRequest currentAccountRequest){
        return currentAccountService.save(currentAccountRequest);
    }

    @PutMapping("/{id}")
    public CurrentAccountResponse update(@PathVariable Long id,@RequestBody CurrentAccountRequest currentAccountRequest){
        return currentAccountService.update(id,currentAccountRequest);
    }

    @GetMapping("/{id}")
    public CurrentAccountResponse getOne(@PathVariable Long id){
        return currentAccountService.getOne(id);
    }


    @PostMapping("/page")
    public Page<CurrentAccountResponse> getAll(@RequestBody MyPageRequest myPageRequest){
        return currentAccountService.getAll(myPageRequest);
    }
    @PostMapping("/filter")
    public Page<CurrentAccountResponse> filter(@RequestBody AccountSpecRequest accountSpecRequest){
        return currentAccountService.filter(accountSpecRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        currentAccountService.delete(id);
    }

}
