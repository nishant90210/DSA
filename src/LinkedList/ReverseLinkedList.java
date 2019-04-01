package LinkedList;

/**
 * Created by NISHANT on 7/4/17.
 */
public class ReverseLinkedList {

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

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);

        reverseLinkedList.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        System.out.println(":Elements before reversing the linked list : ");
        reverseLinkedList.printList(reverseLinkedList.head);

        Node node = reverseLinkedList.reverseLinkedList(reverseLinkedList.head);

        System.out.println();
        System.out.println(":Elements After reversing the Linked List : ");
        reverseLinkedList.printList(node);
//        while (node != null){
//            System.out.println("Element after reversing the Linked List " + node.data);
//            node = node.next;
//        }

    }

    public Node reverseLinkedList(Node node){
        // For first node, previousNode will be null
        Node currentNode = node, prev = null, nextNode;
        if (currentNode == null){
            System.out.println("Empty List");
        }
        while (currentNode != null){
            nextNode = currentNode.next;
            // reversing the link
            currentNode.next = prev;
            // moving currentNode and previousNode by 1 node
            prev = currentNode;
            currentNode = nextNode;
        }
        return prev;
    }

    public void printList(Node node){
        if (node == null){
            System.out.println("Empty List");
        }else {
            while (node != null){
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }
}