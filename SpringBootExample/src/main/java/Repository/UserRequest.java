package Repository;

@Component
public class UserRequest {
    @NotNull(message = "Username should not be null")
    private String fname;

    @NotNull(message = "Username should not be null")
    private String lname;

    @NotNull(message = "Age should not be null")
    @Min(18)
    @Max(60)
    private Integer age;

    @NotNull(message = "Gender should not be null")
    private String gender;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number entered")
    private String mobile;

    @Email(message = "Invalid Email entered")
    private String mail;

    /*A password contains at least eight characters, including at least one number and includes both lower and uppercase letters and special characters, for example #, ?, !.*/
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$\"", message = "Enter valid Password")
    private String password;

    @NotNull(message = "Street should not be null")
    private String street;

    @NotNull(message = "City should not be null")
    private String city;

    @NumberFormat
    private Integer pincode;

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

    public UserRequest(Integer id,String fname,String lname,Integer age,String gender,String mobile,String mail,String password,String Street,String city,Integer pincode){
        super();
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

    @Override
    public String toString(){
        return "User Request[fname = " + fname + ", lname = " + lname + ", age = " + age + ", gender = " + gender + ", mobile = " + mobile + "email = " + mail + "street = " + street + "city = " + city + "pincode = " + pincode + "]";
    }
}
