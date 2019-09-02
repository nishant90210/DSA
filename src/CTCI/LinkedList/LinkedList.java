package CTCI.LinkedList;

public class LinkedList {

    Node head;

    static class Node{
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public void appendToTail(int data) {

        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void displayList(Node node) {

        if (node == null){
            return;
        }
        while (node != null){
            System.out.print(node.data + " --> ");
            node = node.next;
        }
    }
}
