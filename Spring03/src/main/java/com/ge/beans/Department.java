package com.ge.beans;

public class Department {

    private Integer departmentNumber;

    private String departmentName;

    public Department(Integer departmentNumber, String departmentName){
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        System.out.println("Department Bean is Created.");
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentNumber=" + departmentNumber +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
