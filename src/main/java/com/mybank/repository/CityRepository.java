package com.mybank.repository;

import com.mybank.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by koval on 15.02.2018.
 */

@Repository
public interface CityRepository extends JpaRepository<City,Long>{

    //@Query("select c from city c where c.name=:name")
    //City findOne(@Param("name") String name);

    List<City> findAllByCountryName(String countryName);

    City findCityByName(String  name);
}
