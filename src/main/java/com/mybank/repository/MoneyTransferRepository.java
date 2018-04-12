package com.mybank.repository;

import com.mybank.dto.response.MoneyTransferResponse;
import com.mybank.entity.Account;
import com.mybank.entity.MoneyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransfer,Long>{

    List<MoneyTransfer> findAllByResiver(Account sender);

}
