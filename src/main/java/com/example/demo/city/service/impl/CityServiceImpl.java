package com.example.demo.city.service.impl;

import com.example.demo.city.bean.CityBean;
import com.example.demo.city.dao.CityDao;
import com.example.demo.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityDao cityDao;

    @Override
    public List<Map<String, Object>> getAllCity() {
        return cityDao.getAllCity();
    }

    @Override
    public int getCityCount() {
        return cityDao.getCityCount();
    }

    @Override
    public Map getCityById(int id) {
        return cityDao.getCityById(id);
    }

    @Override
    public int insertCityCore(CityBean cityBean) {
        return cityDao.insertCityCore(cityBean);
    }


    @Override
    public int insertCityMap(Map param) {
        return cityDao.insertCityMap(param);
    }

    @Override
    public int insertCityBean(CityBean cityBean) {
        return cityDao.insertCityBean(cityBean);
    }

    @Override
    public int updateCity(CityBean cityBean) {
        return cityDao.updateCity(cityBean);
    }
    @Override
    public int deleteCity(CityBean cityBean) {
        return cityDao.deleteCity(cityBean);
    }
}
