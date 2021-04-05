package LinkedList;

/**
 * Created by NISHANT on 11/20/17.
 */
public class SwapLinkedListPairWise {

    public static void main(String args[]) {
        SinglyLinkedList llist = new SinglyLinkedList();

        /* Created Linked List 1->2->3->4->5->6 */
        llist.addFront(6);
        llist.addFront(5);
        llist.addFront(4);
        llist.addFront(3);
        llist.addFront(2);
        llist.addFront(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        printList(llist.head);

        Node node = pairWiseSwap(llist.head);
        System.out.println();
        System.out.println("Linked List after calling pairWiseSwap() ");
        printList(node);
    }

    private static Node pairWiseSwap(Node head) {

        Node temp = new Node(0);
        temp.next = head;
        Node current = temp;

        while (current.next != null && current.next.next != null) {
            Node firstNode = current.next;
            Node secondNode = current.next.next;
            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }

        return temp.next;
    }


    private static void pairWiseSwapChangeData(Node llist) {

        Node temp = llist;
        if (llist == null) {
            return;
        }
        while (temp != null && temp.next != null) {
            int k = (int) temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

    private static void printList(Node llist) {

        if (llist == null)
            return;
        while (llist != null) {
            System.out.print(" " + llist.data);
            llist = llist.next;
        }
    }
}
