package com.example.demo.fees_detail.service;

import com.example.demo.fees_detail.bean.FeesDetailBean;

import java.util.List;
import java.util.Map;

public interface FeesDetailService {

    public List<Map<String, Object>> getAllFeesDetail();

    public int getFeesDetailCount();

    public Map getFeesDetailById(int id);

    public int insertFeesDetailMap(Map param);

    public int updateFeesDetail(FeesDetailBean feesDetailBean);

    public int deleteFeesDetail(FeesDetailBean feesDetailBean);

}
