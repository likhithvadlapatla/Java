package com.ge.model;

import jakarta.persistence.*;

@Entity // This annotation tells that it a POJO class.
@Table(name = "StudentTable") // If we want to change the table name in the database to a different name other than class name, we can use this annotation and change the name.
public class Student {

    @Id // This annotation tells hibernate that this is the primary key of the table.
    @GeneratedValue(generator = "my_seq", strategy = GenerationType.AUTO) // This annotation generates the values for primary key column(id in this case) starting from 1.
    @SequenceGenerator(name="my_seq", sequenceName = "My_Sequence", initialValue = 100, allocationSize = 1) // This annotation generates the sequence from where we wanted. You can specify the difference between two difference id's with allocationSize parameter. name parameter in SequenceGenerator annotation maps with the generator parameter in GenerateValue annotation.
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
