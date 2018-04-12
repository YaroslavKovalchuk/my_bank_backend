package com.mybank.repository;

import com.mybank.entity.CurrentAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount,Long>, JpaSpecificationExecutor<CurrentAccount> {

    Page<CurrentAccount> findAll(Pageable pageable);

    CurrentAccount findCurrentAccountByAccount_Client_Id(Long id);

}
