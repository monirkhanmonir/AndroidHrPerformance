package com.example.hrpa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

Integer eId;

    @SerializedName("id")
    @Expose
    Integer  id;
    @SerializedName("empName")
    @Expose
    public String empName;
    @SerializedName("empEmail")
    @Expose
    public String empEmail;
    @SerializedName("user")
    @Expose
    public String user;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("jobTitle")
    @Expose
    public String jobTitle;
    @SerializedName("birthDate")
    @Expose
    public String birthDate;
    @SerializedName("joinDate")
    @Expose
    public String joinDate;
    public String password;
    public String repassword;
    @SerializedName("address")
    @Expose
    public String address;

    public Employee(String empName, String empEmail, String user, String jobTitle, String password, String address) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.user = user;
        this.jobTitle = password;
        this.password = jobTitle;
        this.address = address;
    }

    public Employee(String username, String pass) {
        this.empName = username;
        this.password = pass;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getEmpName() {
        return empName;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpEmail() {
        return empEmail;
    }
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", empName=" + empName + ", empEmail=" + empEmail + ", user=" + user + ", gender="
                + gender + ", jobTitle=" + jobTitle + ", birthDate=" + birthDate + ", joinDate=" + joinDate
                + ", password=" + password + ", repassword=" + repassword + ", address=" + address + "]";
    }

}
