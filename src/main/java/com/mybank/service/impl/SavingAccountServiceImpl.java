package com.mybank.service.impl;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.request.SavingAccountRequest;
import com.mybank.dto.response.SavingAccountResponse;
import com.mybank.entity.Account;
import com.mybank.entity.CurrentAccount;
import com.mybank.entity.SavingAccount;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.CurrentAccountRepository;
import com.mybank.repository.SavingAccountRepository;
import com.mybank.service.SavingAccountService;
import com.mybank.specification.SavingAccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class SavingAccountServiceImpl implements SavingAccountService{

    @Autowired
    private SavingAccountRepository savingAccountRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @Override
    @Transactional
    public SavingAccountResponse save(SavingAccountRequest savingAccountRequest) {
        SavingAccount savingAccount = new SavingAccount();
        Account account = accountRepository.findOne(savingAccountRequest.getAccount_id());
        savingAccount.setInterestedRate(savingAccountRequest.getInterestedRate());
        savingAccount.setAccount(account);
        CurrentAccount currentAccount = currentAccountRepository.findCurrentAccountByAccount_Client_Id(account.getClient().getId());
        double amount = currentAccount.getAccount().getBalance() - savingAccount.getAccount().getBalance();
        currentAccount.getAccount().setBalance(amount);
        return new SavingAccountResponse(savingAccountRepository.save(savingAccount));
    }

    @Override
    public SavingAccountResponse update(Long id, SavingAccountRequest savingAccountRequest) {
        SavingAccount savingAccount = savingAccountRepository.findOne(id);
        savingAccount.setInterestedRate(savingAccountRequest.getInterestedRate());
        return new SavingAccountResponse(savingAccountRepository.save(savingAccount));
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findAccountBySavingAccountId(id);
        CurrentAccount currentAccount = currentAccountRepository.findCurrentAccountByAccount_Client_Id(account.getClient().getId());
        double amount = currentAccount.getAccount().getBalance() + account.getBalance();
        currentAccount.getAccount().setBalance(amount);
        accountRepository.delete(account);
    }

    @Override
    public Page<SavingAccountResponse> getAll(MyPageRequest myPageRequest) {

        Page<SavingAccount> clientPage = savingAccountRepository.findAll(
                new PageRequest(myPageRequest.getNumberPage()
                        ,myPageRequest.getSizePage()
                        ,new Sort(myPageRequest.getSortRequest().getDirection(),myPageRequest.getSortRequest().getSortProp())));

        Page<SavingAccountResponse> savingAccountResponsePage = clientPage.map(SavingAccountResponse::new);
        return savingAccountResponsePage;

    }

    @Override
    public SavingAccountResponse getOne(Long id) {
        return new SavingAccountResponse(savingAccountRepository.findOne(id));
    }
    @Override
    public Page<SavingAccountResponse> filter(AccountSpecRequest accountSpecRequest) {
        SavingAccountSpecification accountSpecification = new SavingAccountSpecification(accountSpecRequest);
        PageRequest pageRequest = new PageRequest(accountSpecRequest.getMyPageRequest().getNumberPage(),accountSpecRequest.getMyPageRequest().getSizePage());
        return savingAccountRepository.findAll(accountSpecification,pageRequest).map(SavingAccountResponse::new);
    }

    @Override
    public List<SavingAccountResponse> getAllByClient(Long id) {
        return savingAccountRepository.findAllByAccount_Client_Id(id).stream().map(SavingAccountResponse::new).collect(Collectors.toList());
    }

}
