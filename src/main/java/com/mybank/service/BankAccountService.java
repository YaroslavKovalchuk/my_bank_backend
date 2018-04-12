package com.mybank.service;

import com.mybank.dto.request.BankAccountRequest;
import com.mybank.dto.response.BankAccountResponse;

import java.util.List;

public interface BankAccountService {

    BankAccountResponse save(BankAccountRequest bankAccountRequest);

    BankAccountResponse update(Long id,BankAccountRequest bankAccountRequest);

    void delete(Long id);

    List<BankAccountResponse> getAll();

    BankAccountResponse getOne(Long id);



}
