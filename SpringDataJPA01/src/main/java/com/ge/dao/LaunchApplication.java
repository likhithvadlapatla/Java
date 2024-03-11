package com.ge.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

/*Refer to Execution.txt file in resources folder for flow of the execution.*/
@SpringBootApplication
public class LaunchApplication {
    public static void main(String[] args){
        ConfigurableApplicationContext container = SpringApplication.run(LaunchApplication.class, args);
        IStudentRepo repo = container.getBean(IStudentRepo.class);

        System.out.println("Implementation class of Repo : "+repo.getClass().getName());

//        Student st1 = new Student(1,24,"Eluru");
//        Student st2 = new Student(2,45,"Triveni");
//
//        /*This method saves the data to the table*/
//        Student student1 = repo.save(st1);
//        Student student2 = repo.save(st2);
//        System.out.println(student1);
//        System.out.println(student2);

//        /*This method returns the number of records in the table.*/
//        System.out.println("Number of records in the table : " +repo.count());

//        /*This method deletes the record with the specified id*/
//        repo.deleteById(1);
//        System.out.println("Deleted record with id 1");

        /*This method finds all the records in the table.*/
        Iterable<Student> student1 = repo.findAll();
        for(Student s : student1){
            System.out.println(s);
        }

        /*findAll() method can also be implemented like this.*/
        repo.findAll().forEach((s)->System.out.println(s));

        /*findAll() method can also be implemented like this.*/
        Iterable<Student> records = repo.findAll();
        Iterator<Student> iterator = records.iterator();
        while(iterator.hasNext()){
            Student s = iterator.next();
            System.out.println(s);
        }

        Integer id = 2;
        /*This method tells if the element exists in the database or not.*/
        Boolean status = repo.existsById(id);
        System.out.println("Record with id "+id+" Present ? - "+ status);
    }
}
