/*
      1
     222
    33333
   4444444
  555555555
 */
public class Problem_10 {
    public static void main(String args[]){
        int n=9;
        for(int i=0;i<5;i++){
            for(int j=0;j<n;j++){
                if((j<n/2-i) || (j>n/2+i)){
                    System.out.print(" ");
                }
                else{
                    System.out.print(i+1);
                }
            }
            System.out.println();
        }
    }

}
