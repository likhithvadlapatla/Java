package com.ge.controller;

public class Implementer {
    private Integer id=1;
    private String iname="Likhith";
    private String icity;
    private Double isalary;

    public Implementer(Integer id, String iname, String icity, Double isalary) {
        this.id = id;
        this.iname = iname;
        this.icity = icity;
        this.isalary = isalary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIcity() {
        return icity;
    }

    public void setIcity(String icity) {
        this.icity = icity;
    }

    public Double getIsalary() {
        return isalary;
    }

    public void setIsalary(Double isalary) {
        this.isalary = isalary;
    }

    @Override
    public String toString() {
        return "Implementer{" +
                "id=" + id +
                ", iname='" + iname + '\'' +
                ", icity='" + icity + '\'' +
                ", isalary=" + isalary +
                '}';
    }
}
