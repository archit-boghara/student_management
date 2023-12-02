package com.example.demo.city.service;

import com.example.demo.city.bean.CityBean;

import java.util.List;
import java.util.Map;

public interface CityService {
    public List<Map<String, Object>> getAllCity();

    public int getCityCount();

    public Map getCityById(int id);

    public int insertCityCore(CityBean cityBean);

    public int insertCityMap(Map param);

    public int insertCityBean(CityBean cityBean);

    public int updateCity(CityBean cityBean);

    public int deleteCity(CityBean cityBean);

}
