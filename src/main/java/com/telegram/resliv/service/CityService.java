package com.telegram.resliv.service;

import com.telegram.resliv.model.City;

import java.util.List;

public interface CityService {
    void addCity(City city);

    City getById(int id);

    City getByName(String name);

    List<City> getAll();

    void update(City city);

    void delete(int id);
}
