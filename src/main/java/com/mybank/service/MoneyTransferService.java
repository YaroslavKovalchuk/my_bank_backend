package com.mybank.service;

import com.mybank.dto.request.MoneyTransferRequest;
import com.mybank.dto.response.MoneyTransferResponse;
import com.mybank.entity.MoneyTransfer;

import java.util.Date;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface MoneyTransferService {

    MoneyTransferResponse save(MoneyTransferRequest moneyTransferRequest);
    MoneyTransferResponse update(Long id,MoneyTransferRequest moneyTransferRequest);
    void delete(Long id);
    List<MoneyTransferResponse> getAll();
    MoneyTransferResponse getOne(Long id);
    List<MoneyTransferResponse> findAllBySender(Long id);
}
