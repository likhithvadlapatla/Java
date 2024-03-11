import java.util.*;
public class HashSetProgram1 {
    public static void main(String[] args){
        Set<String> hash_set = new HashSet<String>();

        /*add method*/
        hash_set.add("Likhith");
        hash_set.add("Lokesh");
        hash_set.add("Manoj");
        hash_set.add("Nagarjuna");
        System.out.println(hash_set);

        /*contains method*/
        String check = "Likhith";
        System.out.println(hash_set.contains(check));

        /*remove*/
        hash_set.remove("Likhith");
        System.out.println("Hash Set after removing the element : "+hash_set);

        /*Iterating through the set*/
        for(String value:hash_set){
            System.out.print(value);
        }

        /*Iterating using Iterator*/
    }
}
