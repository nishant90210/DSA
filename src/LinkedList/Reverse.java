package LinkedList;

import java.util.LinkedList;

/**
 * Created by NISHANT on 4/25/18.
 */
public class Reverse {

    Node head;

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void printList() {

        Node node = head;
        while (node!= null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Reverse llist = new Reverse();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);

        llist.printList();
        Node node = llist.reverseList();
        System.out.println();
        llist.printList(node);
    }

    public void printList(Node node) {

        Node root = node;
        while (root!= null){
            System.out.print(root.data + " ");
            root = root.next;
        }
    }

    private Node reverseList() {

        Node prev = null, curr = head, next;
        while (curr != null){

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
