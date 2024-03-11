/*
      1
     212
    32123
   4321234
  543212345
 */
public class Problem_11 {
    public static void main(String args[]){
        int n=9;
        int t1=5,t2=2;
        for(int i=0;i<5;i++){
            for(int j=0;j<n;j++){
                if(j<n/2-i || j<n/2+i){
                    System.out.print(" ");
                }
                else{
                    if(j<n/2){
                        System.out.print(t1);
                    }
                    else if(j>n/2){
                        System.out.print(t2);
                    }
                    else{
                        System.out.print(1);
                    }
                }
            }

        }
    }
}



