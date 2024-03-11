package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApplicationLevel1Cache {
    public static void main(String[] args){
        SessionFactory sessionFactory = null;
        Session session1 = null;
        Session session2 = null;

        /*Instead of writing all the above lines you can also write it like this.*/
        sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        try{
            session1 = sessionFactory.openSession();
            session2 = sessionFactory.openSession();
            /*If you are trying to access a record with primary key(id in this case) which is not in the Level 1 Cache then hibernate will trigger the query.*/
            /*For every session object one cache will be created i.e., called as Level 1 Cache which is responsible for storing the objects of entity class after retrieving the data from the Database.*/
            /*To explain this in layman terminology if you are trying to retrieve a record with id "x" from the Database. If the object with that id is already available in the cache then hibernate will return the object from the cache itself.*/
            /*There will be only one database hit per record in each session. This improves performance.*/
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
