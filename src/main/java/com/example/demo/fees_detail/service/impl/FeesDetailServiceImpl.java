package com.example.demo.fees_detail.service.impl;

import com.example.demo.fees_detail.bean.FeesDetailBean;
import com.example.demo.fees_detail.dao.FeesDetailDao;
import com.example.demo.fees_detail.service.FeesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeesDetailServiceImpl implements FeesDetailService {

    @Autowired
    FeesDetailDao feesDetailDao;

    @Override
    public List<Map<String, Object>> getAllFeesDetail() {
        return feesDetailDao.getAllFeesDetail();
    }

    @Override
    public int getFeesDetailCount() {
        return feesDetailDao.getFeesDetailCount();
    }

    @Override
    public Map getFeesDetailById(int id) {
        return feesDetailDao.getFeesDetailById(id);
    }

    @Override
    public int insertFeesDetailMap(Map param) {
        return feesDetailDao.insertFeesDetailMap(param);
    }

    @Override
    public int updateFeesDetail(FeesDetailBean feesDetailBean){
        return feesDetailDao.updateFeesDetail(feesDetailBean);
    }

    @Override
    public int deleteFeesDetail(FeesDetailBean feesDetailBean){
        return feesDetailDao.deleteFeesDetail(feesDetailBean);
    }

}
