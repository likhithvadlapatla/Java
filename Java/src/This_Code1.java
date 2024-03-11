class Student1{
    int rollno;
    String name;
    float fee;
    Student1(int rollno,String name,float fee){
        rollno=rollno;
        name=name;
        fee=fee;
    }

    void display(){
        System.out.println(rollno+" "+name+" "+fee);
    }
}
public class This_Code1 {
    public static void main(String args[]){
        Student1 s1=new Student1(111,"Likhith",50000);
        Student1 s2=new Student1(112,"Manoj",60000);
        s1.display();
        s2.display();
    }
}
