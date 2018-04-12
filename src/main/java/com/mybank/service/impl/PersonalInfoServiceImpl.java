package com.mybank.service.impl;

import com.mybank.dto.request.PersonalInfoRequest;
import com.mybank.dto.response.PersonalInfoResponse;
import com.mybank.entity.PersonalInfo;
import com.mybank.repository.CityRepository;
import com.mybank.repository.PersonalInfoRepository;
import com.mybank.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public PersonalInfoResponse save(PersonalInfoRequest personalInfoRequest) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName(personalInfoRequest.getFirstName());
        personalInfo.setLastName(personalInfoRequest.getLastName());
        personalInfo.setPhoneNumber(personalInfoRequest.getPhoneNumber());
        personalInfo.setAge(personalInfoRequest.getAge());
        personalInfo.setImgFile(personalInfoRequest.getImgFile());
        personalInfo.setCity(cityRepository.findCityByName(personalInfoRequest.getIdCity()));
        return new PersonalInfoResponse(personalInfoRepository.save(personalInfo));
    }

    @Override
    public PersonalInfoResponse update(Long id, PersonalInfoRequest personalInfoRequest) {


        PersonalInfo personalInfo = personalInfoRepository.findOne(id);

        if (personalInfoRequest.getFirstName() != null){
             personalInfo.setFirstName(personalInfoRequest.getFirstName());
        }
        if (personalInfoRequest.getLastName() != null){
                personalInfo.setLastName(personalInfoRequest.getLastName());
        }
        if (personalInfoRequest.getAge() != 0){
                personalInfo.setAge(personalInfoRequest.getAge());
        }
        if (personalInfoRequest.getPhoneNumber() != null){
                personalInfo.setPhoneNumber(personalInfoRequest.getPhoneNumber());
        }
        if (personalInfoRequest.getImgFile() != null){
                personalInfo.setImgFile(personalInfoRequest.getImgFile());
        }
        if (personalInfoRequest.getIdCity() != null){
            personalInfo.setCity(cityRepository.findCityByName(personalInfoRequest.getIdCity()));
        }
        return new PersonalInfoResponse(personalInfoRepository.save(personalInfo));
    }

    @Override
    public void delete(Long id) {
        personalInfoRepository.delete(id);
    }

    @Override
    public List<PersonalInfoResponse> getAll() {
        List<PersonalInfo> personalInfoList = personalInfoRepository.findAll();
        List<PersonalInfoResponse> personalInfoResponseList = new ArrayList<>();
        for (PersonalInfo personalInfo:personalInfoList){
            personalInfoResponseList.add(new PersonalInfoResponse(personalInfo));
        }
        return personalInfoResponseList;
    }

    @Override
    public PersonalInfoResponse getOne(Long id) {
        return new PersonalInfoResponse(personalInfoRepository.findOne(id));
    }
}
