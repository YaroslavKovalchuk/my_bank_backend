package com.mybank.repository;

import com.mybank.entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface SupportRepository extends JpaRepository<Support,Long>{
}
