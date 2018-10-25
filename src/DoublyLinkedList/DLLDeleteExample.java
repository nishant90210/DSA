package DoublyLinkedList;

/**
 * Created by NISHANT on 8/30/17.
 */
public class DLLDeleteExample {

    Node head;

    static class Node {

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
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        if (head != null){
            head.previous = new_Node;
        }
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
        DLLDeleteExample dllist = new DLLDeleteExample();

        dllist.push(2);
        dllist.push(4);
        dllist.push(5);
        dllist.push(8);
        dllist.push(7);
        dllist.push(10);

        System.out.println("Original Linked list ");
        dllist.print();

        System.out.println("After Linked list ");
//        dllist.deleteFront();
        dllist.deleteGivenNode(5);
//        dllist.deleteEnd();
        dllist.print();
    }

    public void deleteFront(){

        if (head == null){
            System.out.println("Empty Linked List");
            return;
        }
        head = head.next;
    }

    public void deleteEnd(){

        if (head == null){
            System.out.println("Empty Linked List");
            return;
        }
        Node node = head;
        while (node.next.next != null){
            node = node.next;
        }
        node.next = null;
    }

    public void deleteGivenNode(int dataToBeDeleted){

        Node temp = head;
        if (temp != null && temp.data == dataToBeDeleted){
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != dataToBeDeleted){
            temp = temp.next;
        }
        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
        return;
    }
}
