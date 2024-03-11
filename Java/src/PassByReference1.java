/*Predict the output*/

public class PassByReference1{

    String name,gender;
    PassByReference1(String name,String gender){
        this.name = name;
        this.gender = gender;
    }
}
class pbr1{

    static PassByReference1 greet(PassByReference1 person){
        System.out.println("Hi my name is "+person.name+" and I am a "+person.gender);
        PassByReference1 p1 = new PassByReference1("Likhith Sai Chaitanya","Male");
        return p1;
    }
    public static void main(String args[]){
        PassByReference1 p = new PassByReference1("Likhith","Male");
        PassByReference1 x = greet(p);
        System.out.println(x.name);
        System.out.println(x.gender);
    }
}