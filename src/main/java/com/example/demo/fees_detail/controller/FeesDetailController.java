package com.example.demo.fees_detail.controller;


import com.example.demo.fees_detail.bean.FeesDetailBean;
import com.example.demo.fees_detail.service.FeesDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fees_detail")
public class FeesDetailController {

    @Autowired
    FeesDetailService feesDetailService;

    @GetMapping("/getAllFeesDetail")
    public List<Map<String, Object>> getAllFeesDetail() {
        List<Map<String, Object>> lstAllCity = feesDetailService.getAllFeesDetail();
        System.out.println(lstAllCity);
        return feesDetailService.getAllFeesDetail();
    }

    @GetMapping("/getFeesDetailCount")
    public Map getFeesDetailCount() {
        int iFeesDetailCount = feesDetailService.getFeesDetailCount();

        Map mResult = new HashMap();
        mResult.put("count", iFeesDetailCount);

        System.out.println(mResult);

        return mResult;
    }

    @GetMapping("/getFeesDetailById/{feesId}")
    public Map getFeesDetailById(@PathVariable("feesId") int feesId) {
        System.out.println("getFeesDetailById Call");
        Map mResult = new HashMap();
        try {
            mResult = feesDetailService.getFeesDetailById(feesId);
            System.out.println(mResult);
        } catch (Exception ex) {
            System.out.println("ex--" + ex.getMessage());
        }
        return mResult;
    }

    @PostMapping("/insertFeesDetailMap")
    public Map insertCityMap(@RequestBody Map param) {
        int iRes = feesDetailService.insertFeesDetailMap(param);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "insert successfully");
        } else {
            mResult.put("msg", "insert fail");
        }
        return mResult;
    }

    @PostMapping("/updateFeesDetail")
    public Map updateFeesDetail(@RequestBody FeesDetailBean feesDetailBean) {
        System.out.println("insert FeesDetail Bean");
        System.out.println("feesDetail bean = "+feesDetailBean.toString());
        int iRes = feesDetailService.updateFeesDetail(feesDetailBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "update successfully");
        } else {
            mResult.put("msg", "update fail");
        }
        return mResult;
    }

    @PostMapping("/deleteFeesDetail")
    public Map deleteFeesDetail(@RequestBody FeesDetailBean feesDetailBean) {
        System.out.println("insert FeesDetail Bean");
        System.out.println("feesDetail bean = "+feesDetailBean.toString());
        int iRes = feesDetailService.deleteFeesDetail(feesDetailBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "delete successfully");
        } else {
            mResult.put("msg", "delete fail");
        }
        return mResult;
    }



}
