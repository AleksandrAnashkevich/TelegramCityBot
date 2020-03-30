package com.telegram.resliv.service.impl;

import com.telegram.resliv.model.City;
import com.telegram.resliv.repository.CityRepository;
import com.telegram.resliv.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void addCity(City city) {
        cityRepository.save(city);
    }

    @Override
    public City getById(int id) {
        return cityRepository.getOne(id);
    }

    @Override
    public City getByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public void update(City city) {
        delete(city.getId());
        addCity(city);

    }

    @Override
    public void delete(int id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
        }
    }

}
