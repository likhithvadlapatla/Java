/*Write a program to find the value of one number raised to the power of another. (Do not use Java built-in method)*/
public class Problem_4 {
    public static void main(String args[]){
        int a=2,b=5,power=1;
        for(int i=1;i<=b;i++){
            power *= a;
        }
        System.out.println("Power of "+a+" raised to the power "+b+" is "+power);
    }
}
