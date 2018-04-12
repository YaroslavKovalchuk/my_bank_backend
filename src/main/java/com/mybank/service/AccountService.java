package com.mybank.service;

import com.mybank.dto.request.AccountRequest;
import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.AccountResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {

     AccountResponse save(AccountRequest accountRequest);
     AccountResponse update(Long id,AccountRequest accountRequest);
     void delete(Long id);
     List<AccountResponse>getAll();
     AccountResponse getOne(Long id);

     AccountResponse findByClient(AccountRequest accountRequest);

     Page<AccountResponse> filter(AccountSpecRequest accountSpecRequest);

}
