package DoublyLinkedList;

/**
 * Created by NISHANT on 9/4/17.
 */
public class ReverseDLL {

    Node head;

    static class Node{

        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    //Adding a node at the front of the list
    public void push(int new_data) {
    /* 1. allocate node
    * 2. put in the data */
        Node new_Node = new Node(new_data);

    /* 3. Make next of new node as head and previous as NULL */
    /* previous is already null */
        new_Node.next = head;

    /* 4. change prev of head node to new node */
        if (head != null)
            head.previous = new_Node;

    /* 5. move the head to point to the new node */
        head = new_Node;
    }

    public void print(){
        Node temp = head;
        if (temp == null){
            System.out.println("Empty List");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ReverseDLL dllist = new ReverseDLL();

        dllist.push(2);
        dllist.push(4);
        dllist.push(5);
        dllist.push(8);
        dllist.push(7);
        dllist.push(10);

        System.out.println("Original Linked list ");
        dllist.print();

        System.out.println("After Linked list ");
        dllist.reverseList();
        dllist.print();
    }

    public void reverseList(){

        Node current = head;
        Node temp = null;

        while (current != null){
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
        if (temp != null){
            head = temp.previous;
        }
    }
}