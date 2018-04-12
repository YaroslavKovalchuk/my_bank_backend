package com.mybank.service;

import com.mybank.dto.request.ClieantRequest;
import com.mybank.dto.request.LoginRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.ClientResponse;
import com.mybank.dto.response.TokenResponse;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */

public interface ClientService {

     ClientResponse save(ClieantRequest clieantRequest);
     ClientResponse update(Long id,ClieantRequest clieantRequest);
     void delete(Long id);
     Page<ClientResponse> getAll(MyPageRequest myPageRequest);
     ClientResponse getOne(Long id);

     Long getOneByEmail(String email);
     String login(LoginRequest loginRequest);

}
