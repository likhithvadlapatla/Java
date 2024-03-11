import java.util.Scanner;
class Atm1 {
    int pin,balance,user_input,withdrawal_amount,new_pin1,new_pin2,old_pin,user_pin;
    Atm1(){
        this.pin=0;
        this.balance=0;
    }

    Scanner sc=new Scanner(System.in);

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
            System.out.println("Enter the pin : ");
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

    void menu(){
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

public class Atm {
    public static void main(String args[]){
        Atm1 a=new Atm1();
        a.menu();
    }
}
