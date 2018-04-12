package com.mybank.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by koval on 15.02.2018.
 */

@Entity
public class MoneyTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long amount;

    private Date dateTransfer;

    @ManyToMany
    private List<Account> resiver = new ArrayList<>();


    public MoneyTransfer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDateTransfer() {
        return dateTransfer;
    }

    public void setDateTransfer(Date dateTransfer) {
        this.dateTransfer = dateTransfer;
    }

    public Account getSender() {
        return resiver.get(0);
    }

    public Account getResiver() {
        return resiver.get(1);
    }

    public void setResiver(List<Account> resiver) {
        this.resiver = resiver;
    }
}
