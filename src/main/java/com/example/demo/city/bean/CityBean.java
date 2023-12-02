package com.example.demo.city.bean;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;


public class CityBean {
    @NotEmpty(message = "Cityid is null, which is not accepted..")
    private String cityid;
    @Length(max = 9, min = 2, message = "invalid length")
    private String city_name;

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "CityBean{" +
                "cityid='" + cityid + '\'' +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
