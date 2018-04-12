package com.mybank.controller;

import com.mybank.dto.request.MoneyTransferRequest;
import com.mybank.dto.response.MoneyTransferResponse;
import com.mybank.service.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/moneyTranfer")
@CrossOrigin
public class MoneyTransferController {

    @Autowired
    private MoneyTransferService moneyTransferService;

    @PostMapping
    public MoneyTransferResponse save(@RequestBody MoneyTransferRequest moneyTransferRequest){
        return moneyTransferService.save(moneyTransferRequest);
    }

    @PutMapping("/{id}")
    public MoneyTransferResponse update(@PathVariable Long id,@RequestBody MoneyTransferRequest moneyTransferRequest){
        return moneyTransferService.update(id,moneyTransferRequest);
    }

    @GetMapping("//{id}")
    public MoneyTransferResponse getOne(@PathVariable Long id){
        return moneyTransferService.getOne(id);
    }

    @GetMapping
    public List<MoneyTransferResponse> getAll(){
        return moneyTransferService.getAll();
    }

    @GetMapping("/sender/{id}")
    public List<MoneyTransferResponse> getAllBySender(@PathVariable Long id){
        return moneyTransferService.findAllBySender(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        moneyTransferService.delete(id);
    }


}
