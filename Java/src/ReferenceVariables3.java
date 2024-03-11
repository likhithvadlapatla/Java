/*Creating an object with reference variable*/

public class ReferenceVariables3 {
    String name,gender;
    ReferenceVariables3(){
        this.name = "Likhith";
        this.gender = "Male";
    }
}

class RV3{
    public static void main(String args[]){
        ReferenceVariables3 rv3 = new ReferenceVariables3();
        ReferenceVariables3 rv = rv3;
        System.out.println(rv3.gender);
        System.out.println(rv.gender);

        /*Changing the attribute value using the second reference variable*/
        rv.name = "Likhith Sai Chaitanya"; /*Changing the name attribute of object using person reference variable also changes the name attribute using p reference variable.*/
        System.out.println(rv.name);
        System.out.println(rv3.name);
    }
}
