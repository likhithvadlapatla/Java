class Customer{
    String name,gender;
    Address address;

    Customer(String name,String gender,Address address){
        this.name=name;
        this.gender=gender;
        this.address=address;
    }

    void print_address(){
        System.out.println(this.address.get_city()+" , "+this.address.state+" , "+this.address.pin);
    }

    void edit_profile(String new_name,String new_city,String new_state,String new_pin){
        this.name=new_name;
        this.address.edit_address(new_city,new_state,new_pin);
    }
}

class Address{

    String state,pin;
    private String city;
    Address(String city,String state,String pin){
        this.city=city;
        this.state=state;
        this.pin=pin;
    }

    public String get_city(){
        return this.city;
    }

    void edit_address(String new_city,String new_state,String new_pin){
        this.city=new_city;
        this.state=new_state;
        this.pin=new_pin;
    }


}

public class Aggregation {
    public static void main(String args[]){
        Address a=new Address("West Haven","Connecticut","06516");
        Customer c=new Customer("Likhith","Male",a);

        c.print_address();

        c.edit_profile("Likhith Sai Chaitanya","Eluru","Andhra Pradesh","534002");
        c.print_address();
    }
}
