/*8:38*/
import java.lang.reflect.Field;
class Person1{
    private String name,gender;
    Person1(){
        name = "Likhith";
        gender = "Male";
    }
}

public class ReflectioninJava {
    public static void main(String args[]){
        Person1 p = new Person1();
       // p.name = "Likhith Sai Chaitanya";
    }
}
