package com.example.demo.fees_detail.bean;

public class FeesDetailBean {

    private String feesid;
    private String studentid;
    private String amount;
    private String payment_date;

    @Override
    public String toString() {
        return "FeesDetailBean{" +
                "feesid='" + feesid + '\'' +
                ", studentid='" + studentid + '\'' +
                ", amount='" + amount + '\'' +
                ", payment_date='" + payment_date + '\'' +
                '}';
    }

    public String getFeesid() {
        return feesid;
    }

    public void setFeesid(String feesid) {
        this.feesid = feesid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
}
