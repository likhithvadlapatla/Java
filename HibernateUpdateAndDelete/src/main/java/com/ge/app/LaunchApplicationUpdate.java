package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApplicationUpdate {
    public static void main(String[] args){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;

//        config = new Configuration();
//        config.configure();
        /*The bottom line tells hibernate that it needs to convert Employee pojo into the database table*/
        /*If you didn't mention the mapping details in the configuration file, you can use the method mentioned below to map*/
//        config.addAnnotatedClass(Student.class);
//        sessionFactory = config.buildSessionFactory();

        /*Instead of writing all the above lines you can also write it like this.*/
        sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        /*We are writing the logic to update the data in the database. This is the place where Exception can occur. Hence, we are writing the code inside try, catch and finally blocks. To handle the exceptions in hibernate we have Hibernate Exception.*/
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Student student = new Student();
            student.setSid(4);
            student.setSname("Sai");
            student.setScity("Hyderabad");
            // session.saveOrUpdate(student); // This method will update the information in the database based on ID. If the record is already present in the database then the record will be updated else if there is no record the record gets created.This method is deprecated in the older versions.
            session.merge(student); // This method will update the information in the database based on ID. If the record is already present in the database then the record will be updated else if there is no record the record gets created. This method is used in the newer versions.
            flag = true; // This statement is here to tell that the saveOrUpdate operation went successfully. Hence, in the finally block we are committing the transaction if this variable is true else we are rolling back.
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(flag){
                transaction.commit();
            }
            else{
                transaction.rollback();
            }
            session.close();
            sessionFactory.close();
        }
    }
}
