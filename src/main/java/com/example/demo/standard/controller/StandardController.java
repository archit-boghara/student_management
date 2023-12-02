package com.example.demo.standard.controller;


import com.example.demo.standard.bean.StandardBean;
import com.example.demo.standard.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/standard")
public class StandardController {

    @Autowired
    StandardService standardService;

    @GetMapping("/getAllStandard")
        public List<Map<String, Object>> getAllStandard() {
            List<Map<String, Object>> lstAllStandard = standardService.getAllStandard();
            System.out.println(lstAllStandard);
            return standardService.getAllStandard();
        }

    @GetMapping("/getStandardCount")
        public Map getStandardCount(){
        int  iStandardCount = standardService.getStandardCount();

        Map mResult = new HashMap();
        mResult.put("count", iStandardCount);

        System.out.println(mResult);
        return mResult;

    }

    @GetMapping("/getStandardById/{standardId}")
    public Map getStandardById(@PathVariable("standardId") int standardId) {
        System.out.println("getStandardyById Call");
        Map mResult = new HashMap();
        try {
            mResult = standardService.getStandardById(standardId);
            System.out.println(mResult);
        } catch (Exception ex) {
            System.out.println("ex--" + ex.getMessage());
        }
        return mResult;
    }

    @PostMapping("/insertStandard")
    public Map insertStandard(@RequestBody @Valid StandardBean standardBean) {
        System.out.println("insert Standard Bean");
        System.out.println("standard bean = "+standardBean.toString());
        int iRes = standardService.insertStandard(standardBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "insert successfully");
        } else {
            mResult.put("msg", "insert fail");
        }
        return mResult;
    }

    @PostMapping("/updateStandard")
    public Map updateStandard(@RequestBody @Valid StandardBean standardBean) {
        System.out.println("insert Standard Bean");
        System.out.println("standard bean = "+standardBean.toString());
        int iRes = standardService.updateStandard(standardBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "update successfully");
        } else {
            mResult.put("msg", "update fail");
        }
        return mResult;
    }

    @PostMapping("/deleteStandard")
    public Map deleteCity(@RequestBody StandardBean standardBean) {
        System.out.println("insert Standard Bean");
        System.out.println("city bean = "+standardBean.toString());
        int iRes = standardService.deleteStandard(standardBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "delete successfully");
        } else {
            mResult.put("msg", "delete fail");
        }
        return mResult;
    }



}
