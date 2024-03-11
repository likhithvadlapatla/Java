class Person{
    String name,country;
    Person(String name,String country){
        this.name=name;
        this.country=country;
    }

    void greet(){
        if(this.country=="India"){
            System.out.println("Namaste "+this.country);
        }
        else{
            System.out.println("Hello "+this.country);
        }
    }
}
public class ObjectAccessingClass {
    public static void main(String args[]) {

        /*Creation of the object*/
        Person p = new Person("Likhith", "India");

        /*Accessing the attributes of a class*/
        System.out.println(p.country);
        System.out.println(p.name);

        /*Accessing the methods of a class*/
        p.greet();

    }
}
