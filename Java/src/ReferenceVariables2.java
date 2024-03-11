/*Creating an object with reference variable*/

public class ReferenceVariables2 {
    String name,gender;
    ReferenceVariables2(){
        this.name = "Likhith";
        this.gender = "Male";
    }
}

class RV2{
    public static void main(String args[]){
        ReferenceVariables2 rv2 = new ReferenceVariables2();
        System.out.println(rv2.gender);
    }
}
