package com.mybank.dto.response;

import com.mybank.entity.PersonalInfo;

public class PersonalInfoResponse {

    private Long id;

    private String firtName;

    private String lastName;

    private int age;

    private String phoneNumber;

    private String imgFile;

    private CityResponse cityResponse;

    public PersonalInfoResponse(PersonalInfo personalInfo) {
        this.id = personalInfo.getId();
        this.firtName = personalInfo.getFirstName();
        this.lastName = personalInfo.getLastName();
        this.age = personalInfo.getAge();
        this.phoneNumber = personalInfo.getPhoneNumber();
        this.imgFile = personalInfo.getImgFile();
        this.cityResponse = new CityResponse(personalInfo.getCity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public CityResponse getCityResponse() {
        return cityResponse;
    }

    public void setCityResponse(CityResponse cityResponse) {
        this.cityResponse = cityResponse;
    }
}
