/*Write a Java program to reverse an array of integer values.*/
public class Problem_15 {
    public static void main(String args[]){
        int a[] = {4,5,3,1,2};
        int b[] = new int[5];
        int t=0;
        for(int i=a.length-1;i>=0;i--){
            b[t] = a[i];
            t++;
        }
        for(int i=0;i<a.length;i++){
            System.out.print(b[i]+" ");
        }
    }
}
