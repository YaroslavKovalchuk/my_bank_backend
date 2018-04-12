package com.mybank.service;

import com.mybank.dto.request.SavingAccountRequest;
import com.mybank.dto.request.SupportRequest;
import com.mybank.dto.response.SavingAccountResponse;
import com.mybank.dto.response.SupportResponse;
import com.mybank.entity.Support;

import java.util.Date;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
public interface SupportService {

    SupportResponse save(SupportRequest supportRequest);
    SupportResponse update(Long id,SupportRequest supportRequest);
    void delete(Long id);
    List<SupportResponse> getAll();
    SupportResponse getOne(Long id);

}
