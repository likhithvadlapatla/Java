/*
     *
    ***
   *****
  *******
 *********
 */
public class Problem_9 {
    public static void main(String args[]){
        int n=9;
        for(int i=0;i<5;i++){
            for(int j=0;j<n;j++){
                if(j<n/2-i){
                    System.out.print(" ");
                }
                else if(j>n/2+i){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
