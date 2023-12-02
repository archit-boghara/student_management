package com.example.demo.standard.dao;

import com.example.demo.standard.bean.StandardBean;
import com.example.demo.student.bean.StudentBean;

import java.util.List;
import java.util.Map;

public interface StandardDao {

    public List<Map<String, Object>> getAllStandard();

    public int getStandardCount();

    public Map getStandardById(int id);

    public int insertStandard(StandardBean standardBean);

    public int updateStandard(StandardBean standardBean);

    public int deleteStandard(StandardBean standardBean);


}
