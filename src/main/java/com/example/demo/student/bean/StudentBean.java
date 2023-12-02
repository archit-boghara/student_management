package com.example.demo.student.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public class StudentBean {
    @NotEmpty(message = "Studentid is null, which is not accepted..")
    private String studentid;
    @Size(max = 25)
    private String student_name;
    @Email
    private String emailID;
    @NotEmpty(message = "birth_date is null, which is not accepted..")
    private String birth_date;
    @NotEmpty(message = "joining_date is null, which is not accepted..\"")
    private String joining_date;
    private String blood_group;
    private String mobile_number;
    private String cityid;
    private String standardid;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getStandardid() {
        return standardid;
    }

    public void setStandardid(String standardid) {
        this.standardid = standardid;
    }

    @Override
    public String toString() {
        return "StudnetBean{" +
                "studentid='" + studentid + '\'' +
                ", student_name='" + student_name + '\'' +
                ", emailID='" + emailID + '\'' +
                ", brith_date='" + birth_date + '\'' +
                ", joining_date='" + joining_date + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", cityid='" + cityid + '\'' +
                ", standardid='" + standardid + '\'' +
                '}';
    }
}
