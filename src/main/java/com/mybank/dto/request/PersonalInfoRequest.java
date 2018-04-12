package com.mybank.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PersonalInfoRequest {

    @NotNull
    @Pattern(regexp = "(^[A-Z])[a-z]+")
    private String firstName;

    @NotNull
    @Pattern(regexp = "(^[A-Z])[a-z]+")
    private String lastName;

    @NotNull
    private int age;

    @NotNull
    @Pattern(regexp = "^((\\+?380)([0-9]){9})$")
    private String phoneNumber;

    private String imgFile;

    @NotNull
    private String idCity;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getIdCity() {
        return idCity;
    }

    public void setIdCity(String idCity) {
        this.idCity = idCity;
    }
}
