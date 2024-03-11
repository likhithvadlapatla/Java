import java.util.*;
public class HashMapProgram{
    public static void main(String args[]){
        Map<String, Integer> hash_map = new HashMap<String,Integer>();

        /*Inserting pairs in the above map using put() method*/
        hash_map.put("Likhith",1);
        hash_map.put("Lokesh",2);
        hash_map.put("Manoj",3);
        hash_map.put("Nagarjuna",4);

        /*Traversing through hash-map*/
        /*Map.Entry<String,Integer>: This specifies the type of each element in the collection that we're iterating over. In this case, it represents an entry in the HashMap, where the key is of type String and the value is of type Integer.*/
        /*hash_map.entrySet(): This is the collection over which we're iterating. entrySet() returns a set view of the HashMap, containing all the key-value pairs as Map.Entry objects.*/
        for(Map.Entry<String,Integer> hm : hash_map.entrySet()){
            System.out.print(hm.getKey() + " : ");
            System.out.println(hm.getValue());
        }

        System.out.println();

        /*Changing the element*/
        hash_map.put("Likhith",5);
        System.out.println("Hash Map after changing the element : ");
        System.out.println(hash_map);

        System.out.println();

        /*Removing the element*/
        hash_map.remove("Likhith");
        System.out.println("Hash Map after removing the element : ");
        System.out.println(hash_map);

        System.out.println();

        /*containsKey Method*/
        /*This method is used in Map Interface in Java to check whether a particular key is being mapped into the Map or not. It takes the key element as a parameter and returns True if that element is mapped in the map.*/
        System.out.println(hash_map.containsKey("Likhith")); /*false*/
        System.out.println(hash_map.containsKey("Nagarjuna")); /*true*/

        System.out.println();

        /*containsValue Method*/
        /*This method is used in Map Interface to check whether a particular value is being mapped by a single or more than one key in the Map. It takes the value as a parameter and returns True if that value is mapped by any of the keys in the map.*/
        System.out.println(hash_map.containsValue(1)); /*false*/
        System.out.println(hash_map.containsValue(4)); /*true*/

        System.out.println();

        /*Retrieving the element*/
        System.out.println(hash_map.get("Lokesh"));

        System.out.println();

        /*Checking if the HashMap is empty or not*/
        System.out.println(hash_map.isEmpty());

        System.out.println();

        /*Retrieving the size of the HashMap*/
        System.out.println(hash_map.size());
    }
}
