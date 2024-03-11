/*Write a program to find the factorial value of any number*/
public class Problem_3 {
    public static void main(String args[]){
        int num = 5,factorial = 1;
        for(int i=num;i>0;i--){
            factorial *= i;
        }
        System.out.println("The factorial of "+num+" is : "+factorial);
    }
}
