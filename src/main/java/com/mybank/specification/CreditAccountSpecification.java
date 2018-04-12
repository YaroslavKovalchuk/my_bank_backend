package com.mybank.specification;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.entity.Account;
import com.mybank.entity.CreditAccount;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CreditAccountSpecification implements Specification<CreditAccount> {

    private AccountSpecRequest accountSpecRequest;

    public CreditAccountSpecification(AccountSpecRequest accountSpecRequest) {
        this.accountSpecRequest = accountSpecRequest;
    }

    @Override
    public Predicate toPredicate(Root<CreditAccount> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

            Predicate predicates;
            Join<CreditAccount,Account> creditAccountJoin = root.join("account");
            Predicate predicateBalance = criteriaBuilder.greaterThan(creditAccountJoin.get("balance"),accountSpecRequest.getBalance());
            Predicate predicateCardNumber = criteriaBuilder.like(creditAccountJoin.get("cardNumber"),accountSpecRequest.getCardNumber());
            Predicate predicateState = criteriaBuilder.equal(creditAccountJoin.get("state"),accountSpecRequest.getState());
            predicates =  criteriaBuilder.or(predicateBalance,predicateCardNumber,predicateState);

        return predicates;
    }

}
