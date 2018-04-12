package com.mybank.service.impl;

import com.mybank.dto.request.BankAccountRequest;
import com.mybank.dto.response.BankAccountResponse;
import com.mybank.entity.Account;
import com.mybank.entity.BankAccount;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.BankAccountRepository;
import com.mybank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public BankAccountResponse save(BankAccountRequest bankAccountRequest) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccount(accountRepository.findOne(bankAccountRequest.getAccount_id()));
        return new BankAccountResponse(bankAccountRepository.save(bankAccount));
    }

    @Override
    public BankAccountResponse update(Long id, BankAccountRequest bankAccountRequest) {
        BankAccount bankAccount = bankAccountRepository.findOne(id);
        bankAccount.setAccount(accountRepository.findOne(bankAccountRequest.getAccount_id()));
        return new BankAccountResponse(bankAccountRepository.save(bankAccount));
    }

    @Override
    public void delete(Long id) {
        bankAccountRepository.delete(id);
    }

    @Override
    public List<BankAccountResponse> getAll() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        List<BankAccountResponse> bankAccountResponseList = new ArrayList<>();
        for (BankAccount bankAccount:bankAccountList){
            bankAccountResponseList.add(new BankAccountResponse(bankAccount));
        }
        return bankAccountResponseList;
    }

    @Override
    public BankAccountResponse getOne(Long id) {
        return new BankAccountResponse(bankAccountRepository.findOne(id));
    }
}
