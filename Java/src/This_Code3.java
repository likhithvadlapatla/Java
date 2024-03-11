class Student3 {
    int rollno;
    String name;
    float fee;
    Student3(int r, String n, float f){
        rollno=r;
        name=n;
        fee=f;
    }

    void display(){
        System.out.println(rollno+" "+name+" "+fee);
    }
}
public class This_Code3 {
    public static void main(String args[]){
        Student3 s1=new Student3(111,"Likhith",50000);
        Student3 s2=new Student3(112,"Manoj",60000);
        s1.display();
        s2.display();
    }
}

