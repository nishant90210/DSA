package TopInterviewQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[]=new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKLists(arr);
        printList(head);
    }

    private static Node mergeKLists(Node[] arr) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for(Node node : arr){
            while (node.next != null){
                priorityQueue.offer(node.data);
                node = node.next;
            }
        }

        Node dummy = new Node(-1);
        Node head = dummy;

        while (!priorityQueue.isEmpty()){

            Integer poll = priorityQueue.poll();
            head.next = new Node(poll);
            head = head.next;
        }
        return dummy.next;
    }

    private static void printList(Node head) {

        while (head != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
    }
}