package com.mybank.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double balance;

    @Column(unique = true)
    @Pattern(regexp = "([2-6]([0-9]{3}) ?)(([0-9]{4} ?){3})")
    private String cardNumber;

    private State state;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "account")
    private BankAccount bankAccount;

    @OneToOne(mappedBy = "account")
    private CreditAccount creditAccount;

    @OneToOne(mappedBy = "account")
    private CurrentAccount currentAccount;

    @OneToOne(mappedBy = "account")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private SavingAccount savingAccount;

    @ManyToMany(mappedBy = "resiver")
    private List<MoneyTransfer> moneyTransferSender;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber() {
        int randomNumOne = ThreadLocalRandom.current().nextInt(2, 6 + 1);
        int randomNumTwo = ThreadLocalRandom.current().nextInt(100, 999 + 1);
        int randomNumtThree = ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
        int randomNumFour = ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
        int randomNumFive = ThreadLocalRandom.current().nextInt(1000, 9999 + 1);
        this.cardNumber  = "" + randomNumOne + randomNumTwo + " " + randomNumtThree + " " + randomNumFour + " " + randomNumFive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public List<MoneyTransfer> getMoneyTransferSender() {
        return moneyTransferSender;
    }

    public void setMoneyTransferSender(List<MoneyTransfer> moneyTransferSender) {
        this.moneyTransferSender = moneyTransferSender;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public State isState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
