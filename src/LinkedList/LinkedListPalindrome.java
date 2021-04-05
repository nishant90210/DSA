package LinkedList;

import java.util.Stack;

/**
 * Created by NISHANT on 6/28/17.
 */
public class LinkedListPalindrome {

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
        LinkedListPalindrome linkedListPalindrome = new LinkedListPalindrome();
        linkedListPalindrome.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(2);
        Node fifthNode = new Node(1);

        linkedListPalindrome.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        linkedListPalindrome.printList();
        boolean palindrome = linkedListPalindrome.isPalindromeStack(linkedListPalindrome.head);
        boolean palindromeReverse = linkedListPalindrome.isPalindromeReverseList(linkedListPalindrome.head);
        if (palindromeReverse){
            System.out.println("Palindrome");
        }else {
            System.out.println("Not Palindrome");
        }
    }

    public void printList(){
        Node temp = head;
        if (temp == null){
            System.out.println("Empty List");
        }else {
            while (temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    // Using STACK O(n) Time and space complexity
    public boolean isPalindromeStack(Node node){

        Stack<Integer> nodeStack = new Stack<Integer>();
        Node temp = head;
        if (temp == null){
            System.out.println("Empty List");
        }else {
            while (temp != null) {
//                System.out.println("Going into Stack " + temp.data);
                nodeStack.push(temp.data);
                temp = temp.next;
            }
        }
        temp = head;
        while (temp != null && !nodeStack.isEmpty()) {
            if (temp.data == nodeStack.pop()){
                temp = temp.next;
            }else {
                return false;
            }
        }
        return true;
    }

    public Node reverseLinkedList(Node node) {

        Node currentNode = node, prev = null, nextNode;
        if (currentNode == null){
            System.out.println("Empty List");
        }
        while (currentNode != null){
            nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }
        return prev;
    }


    public boolean isPalindromeReverseList(Node node) {

        Node reserveLinkedList = reverseLinkedList(node);

        Node node1 = node;
        Node node2 = reserveLinkedList;

        while (node1 != null && node2 != null){
            if (node1.data == node2.data){
                node1 = node1.next;
                node2 = node2.next;
            }else {
                return false;
            }
        }
        /* Both are empty return true*/
        if (node1 == null && node2 == null) {
            return true;
        }
        /* Will reach here when one is NULL and other is not */
        return false;
    }
}