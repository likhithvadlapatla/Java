package Model;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "User_Details")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String fname;
    private String lname;
    private Integer age;
    private String gender;
    private String mobile;
    private String mail;
    private String password;
    private String street;
    private String city;
    private Integer pincode;

    public Void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public Void setFName(String fname){
        this.fname = fname;
    }

    public String getFName(){
        return fname;
    }

    public Void setLName(String lname){
        this.lname = lname;
    }

    public String getLName(){
        return lname;
    }

    public Void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return age;
    }

    public Void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public Void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getMobile(){
        return mobile;
    }

    public Void setMail(String mail){
        this.mail = mail;
    }

    public String getMail(){
        return mail;
    }

    public Void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public Void setStreet(String street){
        this.street = street;
    }

    public String getStreet(){
        return street;
    }

    public Void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public Void setPin(Integer pincode){
        this.pincode = pincode;
    }

    public Integer getPin(){
        return pincode;
    }

    public User(Integer id,String fname,String lname,Integer age,String gender,String mobile,String mail,String password,String Street,String city,Integer pincode){
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.mail = mail;
        this.password = password;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    public User(){
        super();
    }

}
