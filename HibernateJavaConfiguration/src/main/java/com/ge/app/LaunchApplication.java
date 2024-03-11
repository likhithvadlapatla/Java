package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApplication {
    public static void main(String[] args){
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;

        config = new Configuration();
        /*If you use set these properties here it is not needed to call the configure method.*/
        config.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        config.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        config.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/JDBC");
        config.setProperty("hibernate.connection.username","likhith");
        config.setProperty("hibernate.connection.password","Likhith@31");
        config.setProperty("hibernate.hbm2ddl.auto","create");
        config.setProperty("hibernate.show_sql","true");
        config.setProperty("hibernate.format_sql","true");
        config.addAnnotatedClass(Student.class);
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        Student student = new Student();
        student.setSid(3);
        student.setSname("Kiran");
        student.setScity("Eluru");

        /*We are writing the logic to save the data in the database. This is the place where Exception can occur. Hence, we are writing the code inside try, catch and finally blocks. To handle the exceptions in hibernate we have Hibernate Exception.*/
        try{
            transaction = session.beginTransaction();
            session.persist(student); // This method will insert the information in the database based on ID
            flag = true; // This statement is here to tell that the save operation went successfully. Hence, in the finally block we are committing the transaction if this variable is true else we are rolling back.
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
