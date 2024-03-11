package com.ge.bean;

public class Employee {

    private Integer id;
    private String name,address;
    private Double salary;

    static {
        System.out.println("Employee Class is Loaded.");
    }

    Employee(){
        System.out.println("Employee Bean is Created.");
    }

    public Employee(Integer id, String name, Double salary, String address){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;

        System.out.println("Parameterised constructor is created.");
    }

    public String employeeTask(){
        return "Every employee acts productive but in reality all of them are less productive.";
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
