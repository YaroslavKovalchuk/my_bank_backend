package com.mybank.service.impl;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.CurrentAccountRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.CurrentAccountResponse;
import com.mybank.entity.CurrentAccount;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.CurrentAccountRepository;
import com.mybank.service.CurrentAccountService;
import com.mybank.specification.CurrentAccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class CurrentAccountServiceImpl implements CurrentAccountService{

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CurrentAccountResponse save(CurrentAccountRequest currentAccountRequest) {
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccount(accountRepository.findOne(currentAccountRequest.getAccount_id()));
        return new CurrentAccountResponse(currentAccountRepository.save(currentAccount));
    }

    @Override
    public CurrentAccountResponse update(Long id, CurrentAccountRequest currentAccountRequest) {
        CurrentAccount currentAccount = currentAccountRepository.findOne(id);
        currentAccount.setAccount(accountRepository.findOne(currentAccountRequest.getAccount_id()));
        return new CurrentAccountResponse(currentAccountRepository.save(currentAccount));
    }

    @Override
    public void delete(Long id) {
        currentAccountRepository.delete(id);
    }

    @Override
    public Page<CurrentAccountResponse> getAll(MyPageRequest myPageRequest) {

        Page<CurrentAccount> clientPage = currentAccountRepository.findAll(
                new PageRequest(myPageRequest.getNumberPage()
                        ,myPageRequest.getSizePage()
                        ,new Sort(myPageRequest.getSortRequest().getDirection(),myPageRequest.getSortRequest().getSortProp())));

        Page<CurrentAccountResponse> currentAccountResponsePage = clientPage.map(CurrentAccountResponse::new);
        return currentAccountResponsePage;
    }

    @Override
    public CurrentAccountResponse getOne(Long id) {
        return new CurrentAccountResponse(currentAccountRepository.findOne(id));
    }

    @Override
    public Page<CurrentAccountResponse> filter(AccountSpecRequest accountSpecRequest) {

        CurrentAccountSpecification accountSpecification = new CurrentAccountSpecification(accountSpecRequest);
        PageRequest pageRequest = new PageRequest(accountSpecRequest.getMyPageRequest().getNumberPage(),accountSpecRequest.getMyPageRequest().getSizePage());
        return currentAccountRepository.findAll(accountSpecification,pageRequest).map(CurrentAccountResponse::new);
    }
}
