
class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DoublyLinkedListBasics {

    Node head;
    Node tail;

    Node current = head;
    /*Traversing from head to the end of the list*/
    public void traverseForward(){
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    /*Traversing from tail to the head*/
    public void traverseBackward(){
        Node current = tail;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    void insertAtBeginning(int data){
        Node temp = new Node(data);
        if(head==null){
            head = temp;
            tail = temp;
        }
        else{
            temp.next= head;
            head.prev = temp;
            head=temp;
        }
    }

    void insertAtEnd(int data){
        Node temp = new Node(data);
        if(tail==null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

}
