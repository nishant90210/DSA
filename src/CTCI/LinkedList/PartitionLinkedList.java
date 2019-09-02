package CTCI.LinkedList;

//Partitioning a linked list around a given value and keeping the original order
//Input : 1->4->3->2->5->2->3, x = 3

//Output: 1->2->2->3->3->4->5

public class PartitionLinkedList {

    public static void main(String[] args) {

        int x = 5;
        LinkedList list = new LinkedList();
        list.appendToTail(3);
        list.appendToTail(5);
        list.appendToTail(10);
        list.appendToTail(2);
        list.appendToTail(8);
        list.appendToTail(2);
        list.appendToTail(1);

        System.out.println("Before ");
        list.displayList(list.head);

        LinkedList.Node node = partitionLL(list.head, x);

        System.out.println();
        System.out.println("After ");
        list.displayList(node);
    }

    private static LinkedList.Node partitionLL(LinkedList.Node head, int x) {

        LinkedList.Node beforeHead = new LinkedList.Node(0);
        LinkedList.Node before = beforeHead;
        LinkedList.Node afterHead = new LinkedList.Node(0);
        LinkedList.Node after = afterHead;

        while (head != null) {
            if (head.data < x){
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
















