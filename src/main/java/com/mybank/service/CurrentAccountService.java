package com.mybank.service;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.dto.request.CurrentAccountRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.CurrentAccountResponse;
import com.mybank.entity.CurrentAccount;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface CurrentAccountService {

    CurrentAccountResponse save(CurrentAccountRequest currentAccountRequest);
    CurrentAccountResponse update(Long id,CurrentAccountRequest currentAccountRequest);
    void delete(Long id);
    Page<CurrentAccountResponse> getAll(MyPageRequest myPageRequest);
    CurrentAccountResponse getOne(Long id);
    Page<CurrentAccountResponse> filter(AccountSpecRequest accountSpecRequest);

}
