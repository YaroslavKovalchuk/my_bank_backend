package com.mybank.repository;

import com.mybank.entity.Account;
import com.mybank.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {

    Account findByCardNumber(String cardNumber);

    @Query("select a from Account a where a.client.id =:clientId and a.currentAccount.account.id = a.id")
    Account findByClientId(@Param("clientId") Long clientId);

    Account findAccountBySavingAccountId(Long id);

    Account findAccountByCreditAccountId(Long id);

}
