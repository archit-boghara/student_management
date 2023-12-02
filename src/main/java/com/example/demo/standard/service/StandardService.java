package com.example.demo.standard.service;

import com.example.demo.standard.bean.StandardBean;

import java.util.List;
import java.util.Map;

public interface StandardService {
    public List<Map<String, Object>> getAllStandard();

    public int getStandardCount();

    public Map getStandardById(int id);

    public int insertStandard(StandardBean standardBean);

    public int updateStandard(StandardBean standardBean);

    public int deleteStandard(StandardBean standardBean);
}
