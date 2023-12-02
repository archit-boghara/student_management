package com.example.demo.standard.bean;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StandardBean {

    @NotNull(message = "Standardid is null, which is not accepted..")
    private String standardid;

    @Length(max = 10, min = 1, message = "invalid length of Standard_name is not accepted")
    @NotEmpty(message = "Standard_name is null, which is not accepted..")
    private String standard_name;
    @NotEmpty(message = "Total_fees is null, which is not accepted..")
    private String total_fees;

    @Override
    public String toString() {
        return "StandardBean{" +
                "standardid='" + standardid + '\'' +
                ", standard_name='" + standard_name + '\'' +
                ", total_fees='" + total_fees + '\'' +
                '}';
    }

    public String getStandardid() {
        return standardid;
    }

    public void setStandardid(String standardid) {
        this.standardid = standardid;
    }

    public String getStandard_name() {
        return standard_name;
    }

    public void setStandard_name(String standard_name) {
        this.standard_name = standard_name;
    }

    public String getTotal_fees() {
        return total_fees;
    }

    public void setTotal_fees(String total_fees) {
        this.total_fees = total_fees;
    }
}
