package LinkedList;

/**
 * Created by NISHANT on 7/5/17.
 */
public class LinkedListLength {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListLength linkedListLength = new LinkedListLength();
        linkedListLength.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);

        linkedListLength.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        int length = linkedListLength.getLength(linkedListLength.head);
        int lengthRecursively = linkedListLength.getLengthRecursively(linkedListLength.head);
        System.out.println("Length of the Linked List is " + length);
        System.out.println("Length of the Linked List Recursively is " + lengthRecursively);
    }

    private int getLengthRecursively(Node head) {
        if (head == null){
            return 0;
        }else return 1 + getLengthRecursively(head.next);
    }

    private int getLength(Node head) {

        Node temp = head;
        int count = 0;
        if (temp == null){
            System.out.println("Empty List");
        }else {
            while (temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }
        return count;
    }


}
