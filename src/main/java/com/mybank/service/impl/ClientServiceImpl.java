package com.mybank.service.impl;

import com.mybank.dto.request.ClieantRequest;
import com.mybank.dto.request.LoginRequest;
import com.mybank.dto.request.MyPageRequest;
import com.mybank.dto.response.ClientResponse;
import com.mybank.dto.response.TokenResponse;
import com.mybank.entity.Client;
import com.mybank.repository.ClientRepository;
import com.mybank.repository.PersonalInfoRepository;
import com.mybank.security.tokenUtils.TokenTool;
import com.mybank.service.ClientService;
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
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private TokenTool tokenTool;

    @Override
    public ClientResponse save(ClieantRequest clieantRequest) {
        Client client = new Client();
        client.setRole();
        client.setEmail(clieantRequest.getEmail());
        client.setPassword(clieantRequest.getPassword());
        client.setPersonalInfo(personalInfoRepository.findOne(clieantRequest.getPersonalInfo_id()));
        return new ClientResponse(clientRepository.save(client));
    }

    @Override
    public ClientResponse update(Long id, ClieantRequest clieantRequest) {
        Client client = clientRepository.findOne(id);
        client.setPassword(clieantRequest.getPassword());
        client.setEmail(clieantRequest.getEmail());
        return new ClientResponse(clientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public Page<ClientResponse> getAll(MyPageRequest myPageRequest) {

        Page<Client> clientPage = clientRepository.findAll(
                new PageRequest(myPageRequest.getNumberPage()
                                ,myPageRequest.getSizePage()
                                ,new Sort(myPageRequest.getSortRequest().getDirection(),myPageRequest.getSortRequest().getSortProp())));

        Page<ClientResponse> clientResponsePage = clientPage.map(ClientResponse::new);

        return clientResponsePage;
    }

    @Override
    public ClientResponse getOne(Long id) {
        return new ClientResponse(clientRepository.findOne(id));
    }

    @Override
    public Long getOneByEmail(String email) {
        return clientRepository.findByEmail(email).getId();
    }

    @Override
    public String login(LoginRequest loginRequest) {
        Client user = clientRepository.findOneByEmail(loginRequest.getLogin());
        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return tokenTool.createToken(user.getEmail(), user.getRole().name());
            } else {
                throw new IllegalArgumentException("Wrong input data");
            }
        } else {
            throw new IllegalArgumentException("Wrong input data");
        }
    }


}