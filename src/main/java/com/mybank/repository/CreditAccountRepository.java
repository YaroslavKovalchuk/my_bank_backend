package com.mybank.repository;

import com.mybank.entity.Account;
import com.mybank.entity.CreditAccount;
import com.mybank.specification.AccountSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount,Long>, JpaSpecificationExecutor<CreditAccount> {

    Page<CreditAccount> findAll(Pageable pageable);

    List<CreditAccount> findAllByAccount_Client_Id(Long id);

}
