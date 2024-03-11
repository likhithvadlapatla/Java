public class PassByReference2 {

    String name,gender;
    PassByReference2(String name,String gender){
        this.name = name;
        this.gender = gender;
    }
}

class pbr2{
    static void greet(PassByReference2 person){
        person.name = "Likhith Sai Chaitanya";
        System.out.println(person.name);
    }

    public static void main(String args[]){
        PassByReference2 p = new PassByReference2("Likhith","Male");
        greet(p);
        System.out.println(p.name);
    }
}
