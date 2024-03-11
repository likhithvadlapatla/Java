/*Write a program to reverse a number*/
public class Problem_5 {
    public static void main(String args[]){
        int num=12345,reverse=0;
        int number=num;
        while(num>0){
            reverse=(reverse*10)+(num%10);
            num=num/10;
        }
        System.out.println("The reverse of a number "+number+" is "+reverse);
    }
}
