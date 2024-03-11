package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchApplicationDelete {
    public static void main(String[] args){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;

        /*Instead of writing all the above lines you can also write it like this.*/
        sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        /*We are writing the logic to delete the data in the database. This is the place where Exception can occur. Hence, we are writing the code inside try, catch and finally blocks. To handle the exceptions in hibernate we have Hibernate Exception.*/
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Student student = new Student();
            student.setSid(4);
            student.setSname("Sai");
            student.setScity("Hyderabad");

            // session.delete(student); // This method will delete the record from the table. This method is deprecated in the older versions.
            session.remove(student); // This method will delete the record from the table. This method is used in the newer versions.
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
