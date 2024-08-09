package com.ge.service;

public class Course {
    private Integer cid;
    private String courseName;
    private Double price;

    public Course(Integer cid, String courseName, Double price) {
        this.cid = cid;
        this.courseName = courseName;
        this.price = price;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", courseName='" + courseName + '\'' +
                ", price=" + price +
                '}';
    }
}
