package LinkedList;

/**
 * Created by NISHANT on 11/20/17.
 */
public class SwapLinkedListPairWise {

    public static void main(String args[])
    {
        SinglyLinkedList llist = new SinglyLinkedList();

        /* Created Linked List 1->2->3->4->5 */
        llist.addFront(6);
        llist.addFront(5);
        llist.addFront(4);
        llist.addFront(3);
        llist.addFront(2);
        llist.addFront(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        printList(llist.head);

        pairWiseSwap(llist.head);
        System.out.println();
        System.out.println("Linked List after calling pairWiseSwap() ");
        printList(llist.head);
    }

    private static void pairWiseSwap(Node llist) {

        Node temp = llist;
        if (llist == null){
            return;
        }
        while (temp != null && temp.next != null){
            int k = (int)temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

    private static void printList(Node llist) {

        if (llist == null)
            return;
        while (llist != null){
            System.out.print(" " + llist.data);
            llist = llist.next;
        }
    }
}
