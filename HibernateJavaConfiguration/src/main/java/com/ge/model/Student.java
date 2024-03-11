package com.ge.model;

import jakarta.persistence.*;

@Entity // This annotation tells that it a POJO class.
@Table(name = "StudentTable") // If we want to change the table name in the database to a different name other than class name, we can use this annotation and change the name.
public class Student {

    @Id // This annotation tells hibernate that this is the primary key of the table.
    @Column(name = "SID") // If we want to change the column name in the database to a different name other than the variable name in the class, we can use this annotation.
    private Integer sid;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "SCITY")
    private String scity;

    public Student(){
        System.out.println("Zero parameterized constructor for Hibernate");
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scity='" + scity + '\'' +
                '}';
    }
}
