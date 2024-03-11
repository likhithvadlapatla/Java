public class Problem_13 {
    public static void main(String args[]){
        int a[][]={{1,2,3},{4,5,6},{7,8,9}};
        int b[][]={{1,2,1},{1,3,1},{1,4,1}};
        int m=3,n=3,o=3,p=3,temp=0;

        if(n==o) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    temp=0;
                    for(int k=0;k<a.length;k++){
                        temp += (a[i][k]*b[k][j]);
                    }
                    System.out.print(temp);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Matrix Multiplication is not possible with the given dimensions of the matrix");
        }
    }
}
