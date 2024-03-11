package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LaunchApplication1 {
    public static void main(String[] args){
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;

        config = new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        try{
            Query<Student> query= session.createQuery("FROM Student",Student.class);
            List<Student> listStudent = query.list();

            for(Student s: listStudent){
                System.out.println(s);
            }
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}
