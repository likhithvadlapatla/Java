/* Program to find first occurrence of the character in the given string.*/
public class Problem_20 {
    public static void main(String[] args){
        String s = "Likhith";
        char c = 'i';
        char[] c1 = s.toCharArray();
        int temp=0,index=0;
        for(int i=0;i<c1.length;i++){
            if(c1[i] == c){
                temp=1;
                index=i;
                break;
            }
        }
        if(temp==1){
            System.out.println("Given character is in the string.");
            System.out.println("The index where character is in the string is : "+index);
        }
        else{
            System.out.println("Given character is not present in the string.");
        }

    }
}
