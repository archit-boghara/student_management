package com.example.demo.standard.service.impl;


import com.example.demo.standard.bean.StandardBean;
import com.example.demo.standard.dao.StandardDao;
import com.example.demo.standard.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    StandardDao standardDao;

    @Override
    public List<Map<String, Object>> getAllStandard() {
        return standardDao.getAllStandard();
    }

    @Override
    public int getStandardCount(){
        return standardDao.getStandardCount();
    }

    @Override
    public Map getStandardById(int id) {
        return standardDao.getStandardById(id);
    }

    @Override
    public int insertStandard(StandardBean standardBean){
        return standardDao.insertStandard(standardBean);
    }

    @Override
    public int updateStandard(StandardBean standardBean) {
        return standardDao.updateStandard(standardBean);
    }

    @Override
    public int deleteStandard(StandardBean standardBean) {
        return standardDao.deleteStandard(standardBean);
    }

}
