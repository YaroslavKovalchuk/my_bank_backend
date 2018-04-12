package com.mybank.service.impl;

import com.mybank.dto.request.AccountRequest;
import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.ClieantRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.AccountResponse;
import com.mybank.entity.Account;
import com.mybank.entity.State;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.ClientRepository;
import com.mybank.service.AccountService;
import com.mybank.specification.AccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public AccountResponse save(AccountRequest accountRequest) {
        Account account = new Account();
        account.setBalance(accountRequest.getBalance());
        account.setCardNumber();
        account.setDate(new Date());
        account.setState(State.CLEAR);
        account.setClient(clientRepository.findOne(accountRequest.getClient_id()));
        return new AccountResponse(accountRepository.save(account));
    }

    @Override
    @Transactional
    public AccountResponse update(Long id, AccountRequest accountRequest) {
        Account account = accountRepository.findOne(id);
            account.setBalance(accountRequest.getBalance());
        if (accountRequest.getState() != null){
            account.setState(accountRequest.getState());
        }

        return new AccountResponse(accountRepository.save(account));
    }

    @Override
    public void delete(Long id) {
        accountRepository.delete(id);
    }

    @Override
    public List<AccountResponse> getAll() {
        List<Account> accountList = accountRepository.findAll();
        List<AccountResponse> accountResponseList = new ArrayList<>();
        for (Account account:accountList){
            accountResponseList.add(new AccountResponse(account));
        }
        return accountResponseList;
    }

    @Override
    public AccountResponse getOne(Long id) {
        return new AccountResponse(accountRepository.findOne(id));
    }

    @Override
    public AccountResponse findByClient(AccountRequest accountRequest) {

        return new AccountResponse(accountRepository.findByClientId(accountRequest.getClient_id()));
    }

    @Override
    public Page<AccountResponse> filter(AccountSpecRequest accountSpecRequest) {

        AccountSpecification accountSpecification = new AccountSpecification(accountSpecRequest);

        PageRequest pageRequest = new PageRequest(accountSpecRequest.getMyPageRequest().getNumberPage(),accountSpecRequest.getMyPageRequest().getSizePage());

        return accountRepository.findAll(accountSpecification,pageRequest).map(AccountResponse::new);
    }
}
