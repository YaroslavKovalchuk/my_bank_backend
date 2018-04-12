package com.mybank.repository;

import com.mybank.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

    Client findByEmail(String email);

    Client findOneByEmail(String login);

    Page<Client> findAll(Pageable pageable);
}
