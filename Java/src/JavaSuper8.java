/*Write a program to even or odd*/
import java.util.*;
class JavaSuper8{
    static void addition(int i,int j){
        int sum = i+j;
        System.out.println(sum);
    }
    public static void main(String args[]){
        int a=8;
        float b = 5;
        double c = 5.2;
        char d = 'c';
        String s = "Hello";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        double user_input = sc.nextDouble();
        System.out.println(a+" "+b+" "+c+" "+d+" "+s);
        a=5;
        int e=5,f=6;
        addition(e,f);
        System.out.println(10%100);
    int num=0;
    if(num==0){
        System.out.println(num+" is neither an odd number nor an even number");

    }
    else if(num%2!=0){
        System.out.println(num+" is an odd number");
    }
    else{
        System.out.println(num+" is an even number");
    }

    for(int i=0;i<=10;i++){
        System.out.print(i+" ");
    }
    System.out.println();

    for(int i=10;i>=0;i--){
        System.out.println(i+" ");
    }
    int i = 0;
    while(i<=10){
        System.out.print(i+" ");
        i++;
    }
    System.out.println();
    i=0;
    do{
      System.out.print(i+" ");
      i++;
    }while(i>=10);


    }

}