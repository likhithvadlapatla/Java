import java.util.*;
public class SinglyLinkedListBasics {
    public static void main(String args[]){
        LinkedList<String> l1 = new LinkedList<String>();

        /*This method appends the element to the end of the list.*/
        l1.add("A");
        l1.add("B");
        /*This method appends the element to the end of the list.*/
        l1.addLast("C");

        /*This method inserts the specific element at beginning of the list.*/
        l1.addFirst("D");

        /*This method inserts the specified element at the specified position in the list.*/
        l1.add(2,"E");

        System.out.println("Linked List after adding all the elements : "+l1);

        /*This method removes the first occurrence of the specified element from the list if it is present.*/
        l1.remove("B");

        /*This method removes the element at specified position in the list.*/
        l1.remove(3);

        /*This method removes the first element from the list.*/
        l1.removeFirst();

        /*This method removes the last element from the list.*/
        l1.removeLast();

        System.out.println("Linked List after removing all the elements : "+l1);

        /*This method replaces the element at the specified position in the list with the specified element.*/
        l1.set(0,"B");

        System.out.println("Linked List after updating the list : "+l1);

        /*Adding some elements to the list to use get and for method.*/
        l1.add("Likhith");
        l1.add("Manoj");
        l1.add("Nagarjuna");
        l1.add("Lokesh");

        /* size() - This method returns the number of elements in the list.*/
        /* get(index) = This method returns the element at the specified position in the list.*/
        for(int i=0;i<l1.size();i++){
            System.out.print(l1.get(i) + " ");
        }

        System.out.println();

        /*This method returns the first element from the list*/
        System.out.println("First element from the list : "+l1.getFirst());

        /*This method returns the last element from the list*/
        System.out.println("Last element from the list : "+l1.getLast());

        /*This method returns an array containing all the elements in the list in proper sequence*/
        Object[] a = l1.toArray();
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();

        /*This method returns True if this list contains the specified element*/
        System.out.println(l1.contains("Z"));

    }
}
