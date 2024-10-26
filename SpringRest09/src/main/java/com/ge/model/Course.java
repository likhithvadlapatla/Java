package com.ge.model;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

/*By extending this class, hateoas is enabled in this application.*/
public class Course extends RepresentationModel{
    private Integer cid;
    private String name;
    private Double price;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Course(Integer cid, String name, Double price) {
        this.cid = cid;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
