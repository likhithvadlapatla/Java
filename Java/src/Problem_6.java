/*Write a program to print out all Armstrong numbers between 1 and 500. If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong number.
For example, 153 = ( 1 * 1 * 1 ) + ( 5 * 5 * 5 ) + ( 3 * 3 * 3 )*/
public class Problem_6 {
    public static void main(String args[]){
        int num1=153,sum=0,temp;
        int i,num2=num1;
        while(num1>0){
            temp=1;
            for(i=1;i<=3;i++){
               temp*=num1%10;
            }
            sum+=temp;
            num1=num1/10;
        }
        if(sum==num2){
            System.out.println(num2+" is a Amstrong Number.");
        }
        else{
            System.out.println(num2+" is not a Amstrong Number.");
        }
    }
}
