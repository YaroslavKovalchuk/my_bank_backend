package com.mybank.service.impl;

import com.mybank.dto.request.MoneyTransferRequest;
import com.mybank.dto.response.MoneyTransferResponse;
import com.mybank.entity.Account;
import com.mybank.entity.MoneyTransfer;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.MoneyTransferRepository;
import com.mybank.service.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.calendar.BaseCalendar;

import javax.persistence.Entity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {

    @Autowired
    private MoneyTransferRepository moneyTransferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public MoneyTransferResponse save(MoneyTransferRequest moneyTransferRequest) {

        MoneyTransfer moneyTransfer = new MoneyTransfer();
        moneyTransfer.setDateTransfer(new Date());
        List<Account> accountList = new ArrayList<>();
        accountList.add(accountRepository.findOne(moneyTransferRequest.getSender_id()));
        accountList.add(accountRepository.findByCardNumber(moneyTransferRequest.getresiverCardNumber()));
        moneyTransfer.setResiver(accountList);
        moneyTransfer.setAmount(moneyTransferRequest.getAmount());
        accountList.get(1).setBalance(accountList.get(1).getBalance() + moneyTransferRequest.getAmount());
        accountList.get(0).setBalance(accountList.get(0).getBalance() - moneyTransferRequest.getAmount());
        return new MoneyTransferResponse(moneyTransferRepository.save(moneyTransfer));
    }

    @Override
    public MoneyTransferResponse update(Long id, MoneyTransferRequest moneyTransferRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {
        moneyTransferRepository.delete(id);
    }

    @Override
    public List<MoneyTransferResponse> getAll() {
        return  moneyTransferRepository.findAll().stream().map(MoneyTransferResponse::new).collect(Collectors.toList());
    }

    @Override
    public MoneyTransferResponse getOne(Long id) {
        return new MoneyTransferResponse(moneyTransferRepository.findOne(id));
    }

    @Override
    public List<MoneyTransferResponse> findAllBySender(Long id) {
        Account sender = accountRepository.findByClientId(id);
        return moneyTransferRepository.findAllByResiver(sender).stream().map(MoneyTransferResponse::new).collect(Collectors.toList());
    }

}
