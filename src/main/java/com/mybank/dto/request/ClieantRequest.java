package com.mybank.dto.request;

import com.mybank.entity.PersonalInfo;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ClieantRequest {

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(min = 6,max = 20)
    private String password;

    @NotNull
    private Long personalInfo_id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPersonalInfo_id() {
        return personalInfo_id;
    }

    public void setPersonalInfo_id(Long personalInfo_id) {
        this.personalInfo_id = personalInfo_id; }

}
