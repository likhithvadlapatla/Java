
class Nodes {
    int data;
    Nodes next;
    Nodes(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Nodes head;


    public void insert(int data) {
        Nodes newNodes = new Nodes(data);
        if (head == null) {
            head = newNodes;
        } else {
            Nodes temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNodes;
        }
    }

    public void display() {
        Nodes temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class SingleLinkedList1 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.display();
    }
}