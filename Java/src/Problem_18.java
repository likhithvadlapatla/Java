/*Write a Java program to find the second largest and smallest element in an array.*/
public class Problem_18 {
    public static void main(String args[]){
        int a[]={3,4,5,2,1};
        int max=0,min=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
            else if(a[i]<min){
                min=a[i];
            }
        }
        for(int i=0;i<a.length;i++){

        }
    }
}
