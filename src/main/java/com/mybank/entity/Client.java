package com.mybank.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koval on 15.02.2018.
 */

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Email
    private String email;

   @NotEmpty
    private String password;

    private Role role;

    @OneToOne
    @JoinColumn(name = "personalInfo_id")
    private PersonalInfo personalInfo;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Support> supportList = new ArrayList<>();


    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Support> getSupportList() {
        return supportList;
    }

    public void setSupportList(List<Support> supportList) {
        this.supportList = supportList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole() {
        this.role = Role.USER;
    }

}
