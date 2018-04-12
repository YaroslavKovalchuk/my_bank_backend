package com.mybank.service;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.CreditAccountRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.CreditAccountResponse;
import com.mybank.entity.CreditAccount;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface CreditAccountService {

   CreditAccountResponse save(CreditAccountRequest creditAccountRequest);
   CreditAccountResponse update(Long id,CreditAccountRequest creditAccountRequest);
   void delete(Long id);
   Page<CreditAccountResponse> getAll(MyPageRequest myPageRequest);
   CreditAccountResponse getOne(Long id);
   Page<CreditAccountResponse> filter(AccountSpecRequest accountSpecRequest);
   List<CreditAccountResponse> findAllByClient(Long id);

}
