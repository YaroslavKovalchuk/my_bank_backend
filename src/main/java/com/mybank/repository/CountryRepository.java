package com.mybank.repository;

import com.mybank.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    //@Query("select c from Country c where c.name=:name")
    //Country findOne(@Param("name") String name);

    Country findCountryByName(String name);
}
