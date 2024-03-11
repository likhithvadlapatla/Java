/*Write a Java program to remove duplicate elements from an array.*/
public class Problem_17 {
    public static void main(String args[]){
        int a[] = {2,3,1,2,1};
        int b[] = new int[a.length],t=0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    b[t]=a[i];
                    t++;
                    break;
                }
            }
        }
    }
}
/*Not done yet*/