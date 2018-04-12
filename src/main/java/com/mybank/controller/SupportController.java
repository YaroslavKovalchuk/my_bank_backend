package com.mybank.controller;

import com.mybank.dto.request.SupportRequest;
import com.mybank.dto.response.SupportResponse;
import com.mybank.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support")
@CrossOrigin
public class SupportController {

    @Autowired
    private SupportService supportService;

    @PostMapping
    public SupportResponse save(@RequestBody SupportRequest supportRequest){
        return supportService.save(supportRequest);
    }

    @PutMapping("/{id}")
    public SupportResponse update(@PathVariable Long id,@RequestBody SupportRequest supportRequest){
        return supportService.update(id,supportRequest);
    }

    @GetMapping("/{id}")
    public SupportResponse getOne(@PathVariable Long id){
        return supportService.getOne(id);
    }

    @GetMapping
    public List<SupportResponse> getAll(){
        return supportService.getAll();
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id){
        supportService.delete(id);
    }
}
