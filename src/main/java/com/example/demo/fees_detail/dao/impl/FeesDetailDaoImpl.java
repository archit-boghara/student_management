package com.example.demo.fees_detail.dao.impl;

import com.example.demo.fees_detail.bean.FeesDetailBean;
import com.example.demo.fees_detail.dao.FeesDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class FeesDetailDaoImpl implements FeesDetailDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Map<String, Object>> getAllFeesDetail() {
        return jdbcTemplate.queryForList("select feesid,studentid,amount,payment_date from fees_detail");
    }

    @Override
    public int getFeesDetailCount() {
        return jdbcTemplate.queryForObject("select count(*) from fees_detail", Integer.class);
    }

    @Override
    public Map getFeesDetailById(int id) {
        System.out.println("id - " + id);
        return jdbcTemplate.queryForMap("select feesid,studentid,amount,payment_date from fees_detail where feesid='" + id + "'");
    }

    @Override
    public int insertFeesDetailMap(Map param){
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("insert into fees_detail(studentid,amount,payment_date) values(:studentid,:amount,:payment_date)", new MapSqlParameterSource(param));
    }

    @Override
    public int updateFeesDetail(FeesDetailBean feesDetailBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("update fees_detail set studentid=:studentid,amount=:amount,payment_date=:payment_date where feesid=:feesid",new BeanPropertySqlParameterSource(feesDetailBean));
    }

    @Override
    public int deleteFeesDetail(FeesDetailBean feesDetailBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        return namedParameterJdbcTemplate.update("delete from fees_detail where feesid=:feesid",new BeanPropertySqlParameterSource(feesDetailBean));
    }

}
