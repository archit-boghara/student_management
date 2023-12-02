package com.example.demo.city.dao.impl;

import com.example.demo.city.bean.CityBean;
import com.example.demo.city.dao.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings("rawtypes")
public class CityDaoImpl implements CityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Map<String, Object>> getAllCity() {
        return jdbcTemplate.queryForList("select cityid,city_name from citymaster");
    }

    @Override
    public int getCityCount() {
        return jdbcTemplate.queryForObject("select count(*) from citymaster", Integer.class);
    }

    @Override
    public Map getCityById(int id) {
        System.out.println("id - " + id);
        return jdbcTemplate.queryForMap("select cityid,city_name from citymaster where cityid='" + id + "'");
    }

    @Override
    public int insertCityCore(CityBean cityBean) {
        return jdbcTemplate.update("insert into citymaster(city_name) values('" + cityBean.getCity_name() + "')");
    }
    
    @Override
    public int insertCityMap(Map param) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("insert into citymaster(city_name) values(:city_name)", new MapSqlParameterSource(param));
    }

    @Override
    public int insertCityBean(CityBean cityBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("insert into citymaster(city_name) values(:city_name)",new BeanPropertySqlParameterSource(cityBean));
    }

    @Override
    public int updateCity(CityBean cityBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("update citymaster set city_name=:city_name where cityid=:cityid",new BeanPropertySqlParameterSource(cityBean));
    }

    @Override
    public int deleteCity(CityBean cityBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("delete from citymaster where cityid=:cityid",new BeanPropertySqlParameterSource(cityBean));
    }

}
