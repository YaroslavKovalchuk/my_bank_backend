package com.mybank.specification;

import com.mybank.dto.request.AccountSpecRequest;
import com.mybank.entity.Account;
import com.mybank.entity.CurrentAccount;
import com.mybank.entity.PersonalInfo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CurrentAccountSpecification implements Specification<CurrentAccount> {

    private AccountSpecRequest accountSpecRequest;

    public CurrentAccountSpecification(AccountSpecRequest accountSpecRequest) {
        this.accountSpecRequest = accountSpecRequest;
    }

    @Override
    public Predicate toPredicate(Root<CurrentAccount> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate predicates;
        Join<CurrentAccount,Account> currentAccountJoinAccount = root.join("account");
        Predicate predicateBalanceLess = criteriaBuilder.greaterThanOrEqualTo(currentAccountJoinAccount.get("balance"),accountSpecRequest.getBalanceLess());
        Predicate predicateBalance = criteriaBuilder.lessThanOrEqualTo(currentAccountJoinAccount.get("balance"),accountSpecRequest.getBalance());
        Predicate predicateCardNumber = criteriaBuilder.like(currentAccountJoinAccount.get("cardNumber"),accountSpecRequest.getCardNumber());
        Predicate predicateState = criteriaBuilder.equal(currentAccountJoinAccount.get("state"),accountSpecRequest.getState());
        //Join<CurrentAccount,PersonalInfo> currentAccountJoinPersonalInfo = root.join("")
        //Predicate predicateName = criteriaBuilder.like(root.get("name"),"%"+accountSpecRequest.getName()+"%");//where name like '%text%'
        predicates =  criteriaBuilder.and(predicateBalance,predicateBalanceLess);

        return predicates;
    }

}
