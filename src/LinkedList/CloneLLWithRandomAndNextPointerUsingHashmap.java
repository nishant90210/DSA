package LinkedList;

import java.util.HashMap;

/**
 * Created by NISHANT on 8/30/18.
 * https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 */
public class CloneLLWithRandomAndNextPointerUsingHashmap {

    static Node head;

    static class Node {
        int data;
        Node next, random;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

        HashMap map = new HashMap();

        Node original = head;
        Node duplicate;

        while (original != null){
            duplicate = new Node(original.data);
            map.put(original, duplicate);
            original = original.next;
        }

        original = head;

        while (original != null){

            duplicate = (Node) map.get(original);
            duplicate.next = (Node) map.get(original.next);
            duplicate.random = (Node) map.get(original.random);
            original = original.next;
        }

    }
}
