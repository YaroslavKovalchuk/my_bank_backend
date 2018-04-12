package com.mybank.repository;

import com.mybank.entity.SavingAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long>,JpaSpecificationExecutor<SavingAccount> {

    Page<SavingAccount> findAll(Pageable pageable);

    List<SavingAccount> findAllByAccount_Client_Id(Long id);

}
