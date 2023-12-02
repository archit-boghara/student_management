package com.example.demo.city.controller;

import com.example.demo.city.bean.CityBean;
import com.example.demo.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CitryController {

    @Autowired
    CityService cityService;

    @GetMapping("/getAllCity")
    public List<Map<String, Object>> getAllCity() {
        List<Map<String, Object>> lstAllCity = cityService.getAllCity();
        System.out.println(lstAllCity);
        return cityService.getAllCity();
    }

    @GetMapping("/getCityById/{cityId}")
    public Map getCityById(@PathVariable("cityId") int cityId) {
        System.out.println("getCityById Call");
        Map mResult = new HashMap();
        try {
            mResult = cityService.getCityById(cityId);
            System.out.println(mResult);
        } catch (Exception ex) {
            System.out.println("ex--" + ex.getMessage());
        }
        return mResult;
    }

    @GetMapping("/getCityCount")
    public Map getCityCount() {
        int iCityCount = cityService.getCityCount();

        Map mResult = new HashMap();
        mResult.put("count", iCityCount);

        System.out.println(mResult);

        return mResult;
    }

    @PostMapping("/insertCityCore")
    public Map insertCityCore(@RequestBody @Valid  CityBean cityBean) {
        System.out.println("insert City Core");
        System.out.println("city bean = "+cityBean.toString());
        int iRes = cityService.insertCityCore(cityBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "insert successfully");
        } else {
            mResult.put("msg", "insert fail");
        }
        return mResult;
    }

    @PostMapping("/insertCityBean")
    public Map insertCityBean(@RequestBody @Valid CityBean cityBean) {
        System.out.println("insert City Bean");
        System.out.println("city bean = "+cityBean.toString());
        int iRes = cityService.insertCityBean(cityBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "insert successfully");
        } else {
            mResult.put("msg", "insert fail");
        }
        return mResult;
    }

//    @PostMapping("/insertCityMap")
//    public Map insertCityMap(@RequestBody @Valid Map param) {
//        int iRes = cityService.insertCityMap(param);
//        Map mResult = new HashMap();
//        if (iRes > 0) {
//            mResult.put("msg", "insert successfully");
//        } else {
//            mResult.put("msg", "insert fail");
//        }
//        return mResult;
//    }

    @PostMapping("/updateCity")
    public Map updateCity(@RequestBody @Valid CityBean cityBean) {
        System.out.println("insert City Bean");
        System.out.println("city bean = "+cityBean.toString());
        int iRes = cityService.updateCity(cityBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "update successfully");
        } else {
            mResult.put("msg", "update fail since provided cityid is not available in the citymaster table..");
        }
        return mResult;
    }

    @PostMapping("/deleteCity")
    public Map deleteCity(@RequestBody CityBean cityBean) {
        System.out.println("insert City Bean");
        System.out.println("city bean = "+cityBean.toString());
        int iRes = cityService.deleteCity(cityBean);
        Map mResult = new HashMap();
        if (iRes > 0) {
            mResult.put("msg", "delete successfully");
        } else {
            mResult.put("msg", "delete fail since provided cityid is not available in the citymaster table.. ");
        }
        return mResult;
    }


}
