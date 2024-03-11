public class Problem_19 {
    public static void main(String args[]) {
        String sentence = "Welcome to Java class";
        String[] s = sentence.split(" ");
        String find="to";
        int temp=0;
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < s.length;i++){
            if(s[i].equals(find)){
                temp = 1;
            }
        }
        if(temp==1){
            System.out.println("Given string "+find+" is present in the list.");
        }
        else{
            System.out.println("Given string "+find+" is not present in the list.");
        }
    }

}
