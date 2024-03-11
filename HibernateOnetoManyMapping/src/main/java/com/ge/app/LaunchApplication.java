package com.ge.app;

import com.ge.model.Answer;
import com.ge.model.Question;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

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
        a1.setQuestion(q1);

        Answer a2 = new Answer();
        a2.setId(2);
        a2.setAnswer("Hibernate is an implementation of JPA");
        a2.setQuestion(q1);

        List<Answer> answer = new ArrayList<Answer>();
        answer.add(a1);
        answer.add(a2);

        q1.setAnswerList(answer);

        try{
            transaction = session.beginTransaction();
            session.persist(q1);
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
