package com.telegram.resliv.repository;

import com.telegram.resliv.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends JpaRepository<City, Integer> {


    @Query(value = "select c from City c where c.name = :name")
    City findByName(@Param("name") String name);

}
