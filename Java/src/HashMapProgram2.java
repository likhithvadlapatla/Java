/*
Given a Student Object with FirstName, LastName and GPA as attributes, Create a Hashmap of 8 students , with Key as the first name and value as Student object.
Write a method that takes student name as input and returns Student object from Hashmap.
 */

import java.io.FileReader;
import java.util.*;
class Students{

    String FirstName,LastName,GPA;
    Students(String FirstName,String LastName,String GPA){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.GPA = GPA;
    }
}


class Check{
    public void student(String name,Map<String,Students> st){
        for(Map.Entry<String,Students> s : st.entrySet()){
            if(name == s.getKey()){
                System.out.println(s.getValue().FirstName + " " + s.getValue().LastName + " " + s.getValue().GPA);
            }
        }
    }
}
public class HashMapProgram2 {
    public static void main(String[] args){
        Students s1 = new Students("Likhith","Vadlapatla","9.5");
        Students s2 = new Students("Lokesh","Pappu","9.6");
        Students s3 = new Students("Manojreddy","Tiyyagura","9.7");
        Students s4 = new Students("Nagarjuna","Vadlapatla","9.8");
        Students s5 = new Students("Manojdeep","Dakavaram","9.9");
        Students s6 = new Students("Pavan","Gannarapu","9.6");
        Students s7 = new Students("Janardhan","Movva","9.5");
        Students s8 = new Students("Harshith","Chava","9.5");

        Map<String,Students> st = new HashMap<String,Students>();
        st.put("Likhith",s1);
        st.put("Lokesh",s2);
        st.put("Manojreddy",s3);
        st.put("Nagarjuna",s4);
        st.put("Manojdeep",s5);
        st.put("Pavan",s6);
        st.put("Janardhan",s7);
        st.put("Harshith",s8);

        Check c = new Check();
        c.student("Likhith",st);
    }

}
