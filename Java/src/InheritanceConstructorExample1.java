public class InheritanceConstructorExample1 {

    private int price;
    String brand;
    int camera;
    InheritanceConstructorExample1(int price,String brand,int camera){
        System.out.println("Inside the parent class constructor");
        this.price = price;
        this.brand = brand;
        this.camera = camera;
    }

    public void buy(){
        System.out.println("Buying a phone");
    }
}

class ChildClass extends InheritanceConstructorExample1{

    ChildClass(int price,String brand,int camera){
        super(price,brand,camera);
    }
    public void buy(){
        System.out.println("Buying a phone");
        super.buy();
    }
}
