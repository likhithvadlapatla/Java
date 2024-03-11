package com.ge.app;

import com.ge.model.Answer;
import com.ge.model.Question;
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
        config.configure();
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();

        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestion("What is Hibernate?");

        Answer a1 = new Answer();
        a1.setId(1);
        a1.setAnswer("Hibernate is an ORM Framework");

        q1.setAnswer(a1);
        a1.setQuestion(q1);

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestion("What is JPA?");

        Answer a2 = new Answer();
        a2.setId(2);
        a2.setAnswer("It is a specification used to persist " + "data between Java object and relational database.");

        q2.setAnswer(a2);
        a2.setQuestion(q2);

        try{
            transaction = session.beginTransaction();
            session.persist(q1);
            session.persist(q2);
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
