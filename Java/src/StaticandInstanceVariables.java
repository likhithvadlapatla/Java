import java.util.Scanner;

class Atm3 {
    private int pin,balance;
    int user_input,withdrawal_amount,new_pin1,new_pin2,old_pin,user_pin,cid;

    static int counter=1;
    Atm3(){
        /*Instance Variables*/
        this.pin=0;
        this.balance=0;
        this.cid=Atm3.counter;
        Atm3.counter+=1;
    }

    Scanner sc=new Scanner(System.in);

    public int get_balance(){
        return this.balance;
    }

    public void set_balance(int new_value){
        if(new_value < 0){
            System.out.println("Balance should not be less than 0.");
        }
        else{
            this.balance = new_value;
        }
    }

    public int get_pin(){
        return this.pin;
    }

    public void set_pin(int new_pin){
        if(String.valueOf(new_pin).length() == 4){
            this.pin = new_pin;
        }
        else{
            System.out.println("Invalid Pin Length. Pin must be 4 digits");
        }
    }

    void create_pin(){
        System.out.println("Enter the pin for your account : ");
        new_pin1 = sc.nextInt();
        sc.nextLine();
        System.out.println("Confirm your pin : ");
        new_pin2 = sc.nextInt();

        if(new_pin1 == new_pin2){
            this.pin = new_pin2;
            System.out.println("You have created your pin successfully");
            System.out.println("Enter your balance : ");
            this.balance = sc.nextInt();
            this.menu();
        }
        else{
            this.menu();
        }
    }

    void change_pin(){
        System.out.println("Enter your old pin : ");
        old_pin = sc.nextInt();
        if(old_pin == this.pin){
            System.out.println("Enter the new pin : ");
            this.pin = sc.nextInt();
            System.out.println("Pin Changed Successfully");
            this.menu();
        }
        else{
            System.out.println("You have entered wrong pin.");
            this.menu();
        }
    }

    void balance_withdrawal(){
        System.out.println("Enter the pin : ");
        user_pin = sc.nextInt();
        if(user_pin == this.pin){
            System.out.println("Enter the amount that you want to withdrawal : ");
            withdrawal_amount = sc.nextInt();
            if(withdrawal_amount <= this.balance){
                this.balance = this.balance- withdrawal_amount;
                System.out.println("Withdrawal Successful.");
                this.menu();
            }
            else{
                System.out.println("You don't have enough sufficient balance to withdraw");
                this.menu();
            }
            this.menu();
        }
        else{
            System.out.println("You have entered incorrect pin");
            this.menu();
        }
    }

    void balance_check(){
        System.out.println("Enter the pin : ");
        user_pin = sc.nextInt();
        if(user_pin == this.pin){
            System.out.println("Your account balance is : "+this.balance);
            this.menu();
        }
        else{
            System.out.println("You have entered incorrect pin");
            this.menu();
        }
    }

    private void menu(){
        System.out.println("""
                Hi, How can I help you?
                              1. Press 1 for Creation of the Pin.
                              2. Press 2 for Pin Change.
                              3. Press 3 for Balance Withdrawal.
                              4. Press 4 for Balance Check.
                              5. Press Anything Else to exit.
                """);
        user_input = sc.nextInt();

        if(user_input == 1){
            this.create_pin();
        }
        else if(user_input == 2){
            this.change_pin();
        }
        else if(user_input == 3){
            this.balance_withdrawal();
        }
        else if(user_input == 4){
            this.balance_check();
        }
        else{
            System.exit(0);
        }
    }

}

public class StaticandInstanceVariables {
    public static void main(String args[]){
        Atm3 a1=new Atm3();
        Atm3 a2=new Atm3();
        Atm3 a3=new Atm3();

        System.out.println(a1.cid);
        System.out.println(a2.cid);
        System.out.println(a3.cid);
    }
}
