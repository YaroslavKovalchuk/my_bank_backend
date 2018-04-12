package com.mybank.specification;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.entity.Account;
import com.mybank.entity.CreditAccount;
import com.mybank.entity.CurrentAccount;
import com.mybank.entity.SavingAccount;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class AccountSpecification implements Specification<Account> {

    private AccountSpecRequest accountSpecRequest;

    public AccountSpecification(AccountSpecRequest accountSpecRequest) {
        this.accountSpecRequest = accountSpecRequest;
    }

    @Override
    public Predicate toPredicate(Root<Account> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate predicates = null;
        String operator = accountSpecRequest.getAccountType();

        if(operator.equals("current")){
            Join<Account,CurrentAccount> currentAccountJoin = root.join("currentAccount");
            predicates = criteriaBuilder.equal(currentAccountJoin.get("account"),root.get("id"));
            Predicate predicateBalance = criteriaBuilder.greaterThan(root.get("balance"),accountSpecRequest.getBalance());
            Predicate predicateCardNumber = criteriaBuilder.like(root.get("cardNumber"),accountSpecRequest.getCardNumber());
            Predicate predicateState = criteriaBuilder.equal(root.get("state"),accountSpecRequest.getState());
            predicates =  criteriaBuilder.or(predicateBalance,predicateCardNumber,predicateState);
        }
        if (operator.equals("saving")){
            Join<Account, SavingAccount> savingAccountJoin = root.join("savingAccount");
            predicates = criteriaBuilder.equal(savingAccountJoin.get("account"),root.get("id"));
            Predicate predicateBalance = criteriaBuilder.greaterThan(root.get("balance"),accountSpecRequest.getBalance());
            Predicate predicateCardNumber = criteriaBuilder.like(root.get("cardNumber"),accountSpecRequest.getCardNumber());
            Predicate predicateState = criteriaBuilder.equal(root.get("state"),accountSpecRequest.getState());
            predicates =  criteriaBuilder.or(predicateBalance,predicateCardNumber,predicateState);
        }
        if (operator.equals("credit")){
            Join<Account, CreditAccount> creditAccountJoin = root.join("creditAccount");
            predicates = criteriaBuilder.equal(creditAccountJoin.get("account"),root.get("id"));
            Predicate predicateBalance = criteriaBuilder.greaterThan(root.get("balance"),accountSpecRequest.getBalance());
            Predicate predicateCardNumber = criteriaBuilder.like(root.get("cardNumber"),accountSpecRequest.getCardNumber());
            Predicate predicateState = criteriaBuilder.equal(root.get("state"),accountSpecRequest.getState());
            predicates =  criteriaBuilder.or(predicateBalance,predicateCardNumber,predicateState);
        }

        return predicates;
    }
}
