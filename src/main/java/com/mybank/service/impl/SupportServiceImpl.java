package com.mybank.service.impl;

import com.mybank.dto.request.SupportRequest;
import com.mybank.dto.response.SupportResponse;
import com.mybank.entity.Support;
import com.mybank.repository.ClientRepository;
import com.mybank.repository.SupportRepository;
import com.mybank.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by koval on 16.02.2018.
 */
@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    private SupportRepository supportRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public SupportResponse save(SupportRequest supportRequest) {
        Support support = new Support();
        support.setMessageContain(supportRequest.getMessageContain());
        support.setMessageDate(new Date());
        support.setClient(clientRepository.findOne(supportRequest.getClient_id()));
        return new SupportResponse(supportRepository.save(support));
    }

    @Override
    public SupportResponse update(Long id, SupportRequest supportRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {
        supportRepository.delete(id);
    }

    @Override
    public List<SupportResponse> getAll() {
        List<Support> supportList = supportRepository.findAll();
        List<SupportResponse> supportResponseList = new ArrayList<>();
        for (Support support:supportList){
            supportResponseList.add(new SupportResponse(support));
        }
        return supportResponseList;
    }

    @Override
    public SupportResponse getOne(Long id) {
        return new SupportResponse(supportRepository.findOne(id));
    }
}
