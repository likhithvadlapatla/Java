package com.ge.app;

import com.ge.model.Courses;
import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaunchApplication {
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

        Courses c1 = new Courses();
        c1.setId(1);
        c1.setCourseName("Java");
        c1.setCoursePrice(1999);

        Courses c2 = new Courses();
        c2.setId(2);
        c2.setCourseName("Hibernate");
        c2.setCoursePrice(499);

        Courses c3 = new Courses();
        c3.setId(3);
        c3.setCourseName("Spring Boot");
        c3.setCoursePrice(999);

        Set<Courses> set1 = new HashSet<>();
        set1.add(c1);
        set1.add(c2);
        set1.add(c3);

        Set<Courses> set2 = new HashSet<>();
        set2.add(c2);
        set2.add(c3);

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("Likhith");
        s1.setCity("Eluru");
        s1.setCourses(set1);

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("Triveni");
        s2.setCity("Eluru");
        s2.setCourses(set2);

        Student s3 = new Student();
        s3.setId(3);
        s3.setName("Kiran");
        s3.setCity("Eluru");
        s3.setCourses(set2);

        try{
            transaction = session.beginTransaction();
            session.persist(s1);
            session.persist(s2);
            session.persist(s3);
            flag = true;
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
