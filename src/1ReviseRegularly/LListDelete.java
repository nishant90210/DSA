package LinkedList;

/**
 * Created by NISHANT on 6/23/17.
 */
public class LListDelete {

    Node head;

    static class Node {

        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }

    }

    public static void main(String[] args) {

        /* Start with the empty list. */
        LListDelete lListDelete = new LListDelete();
        lListDelete.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);

        lListDelete.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

//        lListDelete.deleteFront();
//        lListDelete.deleteLast();
        lListDelete.deleteGivenNode(8);
        lListDelete.printList();

    }

    public void printList(){

        Node n = head;
        while (n != null){
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void deleteFront(){

        if (head == null){
            System.out.println("Empty Linked List");
            return;
        }
        head = head.next;
    }

    public void deleteLast(){
        if (head == null){
            System.out.println("Empty Linked List");
            return;
        }
        Node n = head;
        while (n.next.next != null){
            n = n.next;
        }
        n.next = null;
    }

    public void deleteGivenNode(int dataToBeDeleted){
        Node temp = head, prev = null;

        if (temp != null && temp.data == dataToBeDeleted){
            head = temp.next;
            return;
        }
        while (temp != null && temp.data != dataToBeDeleted){
            prev = temp;
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("Key not found");
            return;
        }
        prev.next = temp.next;
    }
}
