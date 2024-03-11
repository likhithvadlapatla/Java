import java.util.*;

/*
Given a string, write a program to print all the distinct characters and number of times that character is repeated in the string.
input: test string
output: t-3, e-1, s-2, r-1, i-1, n-1, g-1
 */
public class HashMapProgram3 {
    public static void main(String[] args){
        String s = "test string";
        Map<Character,Integer> hm = new HashMap<Character,Integer>();
        char sa[] = s.toCharArray();
        int count = 1;
        for(int i=0;i<sa.length;i++){
            if(sa[i] != ' ') {
                for (int j = i + 1; j < sa.length; j++) {
                    if(sa[i] == sa[j]) {
                        count += 1;
                    }
                }
                if(!hm.containsKey(sa[i])) {
                    hm.put(sa[i], count);
                }
                count = 1;
            }
        }
        System.out.println(hm);
    }
}
