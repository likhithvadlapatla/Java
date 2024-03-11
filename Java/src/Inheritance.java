class User{

    String name,gender;
    int rollno;

    User(){
        this.name="Likhith";
        this.gender="Male";
        this.rollno=66;
    }

    void login(){
        System.out.println("Login Successful");
    }
}

class Student extends User{
    void enroll(){
        System.out.println("Enroll into this course");
    }
}

public class Inheritance {
    public static void main(String args[]){
        Student s = new Student();

        /*Accessing the attributes and methods of a parent class using child class object*/
        System.out.println(s.name); /*"Likhith"*/
        System.out.println(s.gender); /*"Male"*/
        System.out.println(s.rollno); /*66*/
        s.login(); /*"Login Successful"*/

        /*Accessing the method of child class using child class object.*/
        s.enroll(); /*"Enroll into this course"*/

    }

}
