package com.ge.app;

import com.ge.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class LaunchApplication {
    public static void main(String[] args){
        /*Step 1 : Creation of the Configuration Object.*/
        Configuration config = new Configuration();

        /*Step 2 : Configure hibernate.cfg.xml file to Configuration Object.*/
        /*If you are using any other name than hibernate.cfg.xml to the configuration file you need to mention that in the configure() method within double quotes.*/
        config.configure();

        /*Step 3 : Create SessionFactory Object.*/
        SessionFactory sessionFactory = config.buildSessionFactory();

        /*Step 4 : Create the Session Object from Session Factory Object*/
        Session session = sessionFactory.openSession();

        /*Step 5 : Begin the Transaction within the Session*/
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setSid(1);
        student.setSname("Likhith");
        student.setScity("Eluru");

        /*Step 6 : Perform the operation*/
        /*This operation saves the object of the POJO class in the database*/
        session.save(student);

        /*Step 7 : Performing the Transaction Operations*/
        transaction.commit();

        /*Step 8 : Close the Session.*/
        session.close();

    }
}
