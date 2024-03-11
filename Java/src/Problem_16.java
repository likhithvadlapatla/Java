/*Write a Java program to find duplicate values in an array of integer values.*/
public class Problem_16 {
    public static void main(String args[]){
        int a[] = {5,2,1,2,1};
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
        for(int i=0;i<a.length;i++){
            if(b[i]!=0) {
                System.out.print(b[i] + " ");
            }
        }
    }
}
