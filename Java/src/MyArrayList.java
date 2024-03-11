import java.util.ArrayList;

public class MyArrayList {
    public static void main(String args[]){
        ArrayList<String> cars=new ArrayList<String>();
        cars.add("Volvo");
        cars.add("Porsche");
        cars.add("BMW");
        cars.add("Volkswagen");
        cars.add("Bugatti");

        for(String i:cars){
            System.out.println(i);
        }

        /*Adds Tesla at Index 2*/
        cars.add(2,"Tesla");

        /*Returns false since the given element is not in the list*/
        System.out.println(cars.contains("BMw"));

        /*Returns the first occurrence of specific element in the list*/
        System.out.println(cars.indexOf("BMW"));

        /*Returns true if the array list is empty*/
        System.out.println(cars.isEmpty());

        /*Removes the element at index 2*/
        cars.remove(2);

        /*Removes the element "BMW" from the list*/
        cars.remove("BMW");

        /*Returns the length of the array list*/
        System.out.println(cars.size());

        /*Returns the element at index 2 from the list*/
        System.out.println(cars.get(2));

        for(String i:cars){
            System.out.println(i);
        }
    }
}