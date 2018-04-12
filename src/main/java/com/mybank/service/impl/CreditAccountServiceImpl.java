package com.mybank.service.impl;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.CreditAccountRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.AccountResponse;
import com.mybank.dto.response.CreditAccountResponse;
import com.mybank.entity.Account;
import com.mybank.entity.CreditAccount;
import com.mybank.entity.CurrentAccount;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.CreditAccountRepository;
import com.mybank.repository.CurrentAccountRepository;
import com.mybank.service.CreditAccountService;
import com.mybank.specification.AccountSpecification;
import com.mybank.specification.CreditAccountSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class CreditAccountServiceImpl implements CreditAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CreditAccountRepository creditAccountRepository;

    @Autowired
    private CurrentAccountRepository currentAccountRepository;

    @Override
    @Transactional
    public CreditAccountResponse save(CreditAccountRequest creditAccountRequest) {

        CreditAccount creditAccount = new CreditAccount();
        Account account = accountRepository.findOne(creditAccountRequest.getAccount_id());
        CurrentAccount currentAccount = currentAccountRepository.findCurrentAccountByAccount_Client_Id(account.getClient().getId());

        creditAccount.setInterestedRate(creditAccountRequest.getInterestedRate());
        creditAccount.setAccount(account);
        double amount = currentAccount.getAccount().getBalance() + creditAccount.getAccount().getBalance();
        currentAccount.getAccount().setBalance(amount);
       // creditAccount.getAccount().setBalance(creditAccount.getAccount().getBalance() - );
        return new CreditAccountResponse(creditAccountRepository.save(creditAccount));

    }

    @Override
    @Transactional
    public CreditAccountResponse update(Long id, CreditAccountRequest creditAccountRequest) {
        CreditAccount creditAccount = creditAccountRepository.findOne(id);
        creditAccount.setInterestedRate(creditAccountRequest.getInterestedRate());
        return new CreditAccountResponse(creditAccountRepository.save(creditAccount));
    }

    @Override
    public void delete(Long id) {
        creditAccountRepository.delete(id);
    }

    @Override
    public Page<CreditAccountResponse> getAll(MyPageRequest myPageRequest) {

        Page<CreditAccount> clientPage = creditAccountRepository.findAll(
                new PageRequest(myPageRequest.getNumberPage()
                        ,myPageRequest.getSizePage()
                        ,new Sort(myPageRequest.getSortRequest().getDirection(),myPageRequest.getSortRequest().getSortProp())));

        Page<CreditAccountResponse> creditAccountResponsePage = clientPage.map(CreditAccountResponse::new);

        return creditAccountResponsePage;

    }

    @Override
    public CreditAccountResponse getOne(Long id) {
        return new CreditAccountResponse(creditAccountRepository.findOne(id));
    }

    @Override
    public Page<CreditAccountResponse> filter(AccountSpecRequest accountSpecRequest) {

        CreditAccountSpecification accountSpecification = new CreditAccountSpecification(accountSpecRequest);

        PageRequest pageRequest = new PageRequest(accountSpecRequest.getMyPageRequest().getNumberPage(),accountSpecRequest.getMyPageRequest().getSizePage());

        return creditAccountRepository.findAll(accountSpecification,pageRequest).map(CreditAccountResponse::new);
    }

    @Override
    public List<CreditAccountResponse> findAllByClient(Long id) {
        return creditAccountRepository.findAllByAccount_Client_Id(id).stream().map(CreditAccountResponse::new).collect(Collectors.toList());
    }
}
