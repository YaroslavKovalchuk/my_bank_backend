package com.mybank.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by koval on 15.02.2018.
 */

@Entity
public class SavingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer interestedRate;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public SavingAccount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(Integer interestedRate) {
        this.interestedRate = interestedRate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
