package com.ge.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class CustomerInfo {
    @Id
    private Integer id;
    private String cname;
    private String ccity;
    private LocalDateTime dob;
    private LocalTime regTime;
    private LocalDate regDate;

    public CustomerInfo(){
        System.out.println("Zero Parameterized Constructor");
    }

    public CustomerInfo(Integer id, String cname, String ccity, LocalDateTime dob, LocalTime regTime, LocalDate regDate) {
        this.id = id;
        this.cname = cname;
        this.ccity = ccity;
        this.dob = dob;
        this.regTime = regTime;
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcity() {
        return ccity;
    }

    public void setCcity(String ccity) {
        this.ccity = ccity;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalTime regTime) {
        this.regTime = regTime;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", ccity='" + ccity + '\'' +
                ", dob=" + dob +
                ", regTime=" + regTime +
                ", regDate=" + regDate +
                '}';
    }
}
