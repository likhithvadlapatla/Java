import java.util.*;
public class TreeMapProgram{
    public static void main(String args[]){
        Map<String, Integer> hash_map = new HashMap<String,Integer>();

        /*Inserting pairs in the above map using put() method*/
        hash_map.put("Likhith",1);
        hash_map.put("Lokesh",2);
        hash_map.put("Manoj",3);
        hash_map.put("Nagarjuna",4);

        /*Traversing through hash-map*/
        for(Map.Entry<String,Integer> hm : hash_map.entrySet()){
            System.out.print(hm.getKey() + " : ");
            System.out.println(hm.getValue());
        }
    }
}
