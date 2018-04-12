package com.mybank.service;

import com.mybank.dto.request.PersonalInfoRequest;
import com.mybank.dto.response.PersonalInfoResponse;
import com.mybank.entity.PersonalInfo;

import java.util.List;

public interface PersonalInfoService {

    PersonalInfoResponse save(PersonalInfoRequest personalInfoRequest);
    PersonalInfoResponse update(Long id,PersonalInfoRequest personalInfoRequest);
    void delete(Long id);
    List<PersonalInfoResponse> getAll();
    PersonalInfoResponse getOne(Long id);

}
