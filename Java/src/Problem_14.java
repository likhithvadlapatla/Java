/*Write a Java program to find the maximum and minimum value of an array.*/
public class Problem_14 {
    public static void main(String args[]){
        int a[] = {5,4,9,1,6};
        int max = 0,min=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
            else if(a[i]<min){
                min=a[i];
            }
        }
        System.out.println("Maximum value of the array : "+max);
        System.out.println("Minimum value of the array : "+min);
    }
}
