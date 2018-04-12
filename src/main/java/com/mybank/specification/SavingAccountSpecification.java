package com.mybank.specification;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.entity.Account;
import com.mybank.entity.SavingAccount;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class SavingAccountSpecification implements Specification<SavingAccount> {

    private AccountSpecRequest accountSpecRequest;

    public SavingAccountSpecification(AccountSpecRequest accountSpecRequest) {
        this.accountSpecRequest = accountSpecRequest;
    }

    @Override
    public Predicate toPredicate(Root<SavingAccount> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate predicates;
        Join<SavingAccount,Account> creditAccountJoin = root.join("account");
        Predicate predicateBalance = criteriaBuilder.greaterThan(creditAccountJoin.get("balance"),accountSpecRequest.getBalance());
        Predicate predicateCardNumber = criteriaBuilder.like(creditAccountJoin.get("cardNumber"),accountSpecRequest.getCardNumber());
        Predicate predicateState = criteriaBuilder.equal(creditAccountJoin.get("state"),accountSpecRequest.getState());
        predicates =  criteriaBuilder.or(predicateBalance,predicateCardNumber,predicateState);

        return predicates;
    }

}
