package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NISHANT on 8/30/18.
 * https://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
 */
public class CloneLLWithRandomAndNextPointerUsingHashmap {

    static Node head;

    static class Node {
        int val;
        Node next, random;

        public Node(int data) {
            this.val = data;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        System.out.println("Original list : ");
        print(start);

        System.out.println("Cloned list : ");
        Node cloned_list = copyRandomList(start);
        print(cloned_list);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
    /*
      Our clone map. We map the original node to its clone.
      This is the key to the problem, from here all else is simple linear time iteration.
    */
        Map<Node, Node> cloneMap = new HashMap<Node, Node>();

        // 1st pass: Give all nodes their clone in the mapping.
        Node curr = head;
        while (curr != null) {
            cloneMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

    /*
      2nd pass.
      Reset the curr pointer to the head of the original list Give all clones their next and random pointer assignments.
      Our cloneMap lets us reach an original node's clone in O(1) time.
    */
        curr = head;
        while (curr != null) {
      /*
        cloneMap.get(curr).next -> Set the next of curr's clone to...
        cloneMap.get(curr.next) -> The clone of curr's next.
      */
            cloneMap.get(curr).next = cloneMap.get(curr.next);

      /*
        cloneMap.get(curr).random -> Set the random of curr's clone to...
        cloneMap.get(curr.random) -> The clone node that curr.random is pointing to.
      */
            cloneMap.get(curr).random = cloneMap.get(curr.random);

            curr = curr.next;
        }
        // Return the clone node of the head. This is the caller's access to the newly copied list.
        return cloneMap.get(head);
    }

    static void print(Node start) {
        Node ptr = start;
        while (ptr != null)
        {
            System.out.println("Data = " + ptr.val + ", Random = "+ptr.random.val);
            ptr = ptr.next;
        }
    }
}
