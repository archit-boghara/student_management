package com.example.demo.standard.dao.impl;


import com.example.demo.standard.bean.StandardBean;
import com.example.demo.standard.dao.StandardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StandardDaoImpl implements StandardDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllStandard(){
        return jdbcTemplate.queryForList("select standardid, standard_name,total_fees from standardmaster");
    }

    @Override
    public int getStandardCount() {
        return jdbcTemplate.queryForObject("select count(*) from standardmaster", Integer.class);
    }

    @Override
    public Map getStandardById(int id) {
        System.out.println("id - " + id);
        return jdbcTemplate.queryForMap("select standardid,standard_name,total_fees from standardmaster where standardid='" + id + "'");
    }

    @Override
    public int insertStandard(StandardBean standardBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("insert into standardmaster(standardid,standard_name,total_fees) values(:standardid,:standard_name,:total_fees)",new BeanPropertySqlParameterSource(standardBean));
    }

    @Override
    public int updateStandard(StandardBean standardBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("update standardmaster set standard_name=:standard_name,total_fees=:total_fees where standardid=:standardid",new BeanPropertySqlParameterSource(standardBean));
    }

    @Override
    public int deleteStandard(StandardBean standardBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("delete from standardmaster where standardid=:standardid",new BeanPropertySqlParameterSource(standardBean));
    }


}
