package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApplicationLevel2Cache {
    public static void main(String[] args){
        SessionFactory sessionFactory = null;
        Session session1 = null;
        Session session2 = null;

        sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        try{
            session1 = sessionFactory.openSession();
            session2 = sessionFactory.openSession();


            /*In Level2 Cache the cache is created ay SessionFactory level , which means there will be only one common cache for all the sessions.*/
            /*So in this example, for both the session objects(session1, session2) only one common cache will be created.*/
            /*This cache is not available by default in the application. Hence we have imported third party information i.e., EH cache in our application.*/
            Student student1 = session1.get(Student.class,2);
            System.out.println(student1);
            Student student2 = session1.get(Student.class,2);
            System.out.println(student2);


            Student student3 = session2.get(Student.class,2);
            System.out.println(student3);
            Student student4 = session2.get(Student.class,2);
            System.out.println(student4);
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session1.close();
            session2.close();
            sessionFactory.close();
        }
    }
}
