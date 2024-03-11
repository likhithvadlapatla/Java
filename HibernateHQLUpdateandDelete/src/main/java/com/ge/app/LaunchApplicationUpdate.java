package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LaunchApplicationUpdate {
    public static void main(String[] args){
        Configuration config = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Boolean flag = false;
        Integer count = 0;

        config = new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        try{
            transaction = session.beginTransaction();
            count= session.createMutationQuery("Update Student SET name = :name WHERE id = :id").setParameter("name","Chandra Kiran").setParameter("id",3).executeUpdate();
            flag = true;
        }
        catch(HibernateException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if(flag == true){
                transaction.commit();
                System.out.println("Number of Rows Updated : "+ count);
            }
            else{
                transaction.rollback();
                System.out.println("Number of Rows Updated : "+ count);
            }
            session.close();
            sessionFactory.close();
        }
    }
}
