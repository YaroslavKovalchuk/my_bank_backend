package com.mybank.service;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.request.SavingAccountRequest;
import com.mybank.dto.response.SavingAccountResponse;
import com.mybank.entity.SavingAccount;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface SavingAccountService {

    SavingAccountResponse save(SavingAccountRequest savingAccountRequest);
    SavingAccountResponse update(Long id,SavingAccountRequest savingAccountRequest);
    void delete(Long id);
    Page<SavingAccountResponse> getAll(MyPageRequest myPageRequest);
    SavingAccountResponse getOne(Long id);
    Page<SavingAccountResponse> filter(AccountSpecRequest accountSpecRequest);
    List<SavingAccountResponse> getAllByClient(Long id);

}
