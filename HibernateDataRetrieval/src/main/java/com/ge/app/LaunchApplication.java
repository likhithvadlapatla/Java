package com.ge.app;

import com.ge.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchApplication {
    public static void main(String[] args){
        SessionFactory sessionFactory = null;
        Session session = null;

        /*Instead of writing all the above lines you can also write it like this.*/
        sessionFactory= new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        /*We are writing the logic to delete the data in the database. This is the place where Exception can occur. Hence, we are writing the code inside try, catch and finally blocks. To handle the exceptions in hibernate we have Hibernate Exception.*/
        try{
            session = sessionFactory.openSession();
            /*If you use get() method only one object gets created which is actual object. Hence eager loading takes place when you use this method*/
            //Student student1 = session.get(Student.class,2);
            /*If you print the object directly, it will call the toString() method which we are overriding in Student Class*/
            //System.out.println(student);
            //if(student == null) {
                /*Instead of printing the object through toString() method, we can also use getter methods of the student class.*/
    //            System.out.println("Output of get() method : ");
    //            System.out.println("ID is : "+ student1.getSid());
    //            System.out.println("Name is : "+ student1.getSname());
    //            System.out.println("City is : "+ student1.getScity());
            //}
//            else{
//                System.out.println("There is no Record/Data with given ID.");
//            }

            System.out.println("Output of load() method : ");
            /*load() and getReference() methods exactly works in same manner*/
            /*load() method is deprecated in the newer versions hence we need to use getReference() method*/
            /*Both of these methods creates proxy and actual objects.*/
            /*Proxy object is the fake object which gets created to support lazy loading. It is created just to return the primary key information(id in this example)*/
            /*These methods only create actual object only when you request for the information other than the primary key*/
            /*This supports Lazy Loading for not loading everything at once.*/
            /*If you only request for the primary key(id in this case) these methods won't even create the JDBC environment and interact with the Database.*/
            Student student2 = session.load(Student.class,2);
            System.out.println("ID is : "+ student2.getSid());
            /*This method is used to pause the execution until you press Enter/Return button. Just to show that the ID is printed after creating proxy object not actual object we are using this.*/
            System.in.read();
            System.out.println("Name is : "+ student2.getSname());
            System.out.println("City is : "+ student2.getScity());

//            System.out.println("Output of getReference() method : ");
//            Student student3 = session.getReference(Student.class,2);
//            System.out.println("ID is : "+ student3.getSid());
//            System.out.println("Name is : "+ student3.getSname());
//            System.out.println("City is : "+ student3.getScity());

            /*If you want to retrieve the data that is not in the table with get() method NullPointerException occurs(we can handle it through if/else block like we did above) but if you use load()/getReference() method proxy object is created but ObjectNotFoundException occurs(we can handle through if/else block) when it is trying to create an actual object.*/
            /*This is also one of the reason to tell load()/getReference() methods supports lazy loading.*/
            //Student student2 = session.load(Student.class,44);
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
