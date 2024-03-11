/*Creating an object without reference*/

public class ReferenceVariables1 {
    String name,gender;
    ReferenceVariables1(){
        this.name = "Likhith";
        this.gender = "Male";
    }
}

class RV1{
    public static void main(String args[]){
        System.out.println(new ReferenceVariables1().gender);
    }
}
