package LinkedList;

/**
 * Created by NISHANT on 11/15/17.
 */
// https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class IntersectionOfTwoList {

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();

        // creating first linked list1
        list1.addLast(3);
        list1.addLast(15);
        list1.addLast(30);

        SinglyLinkedList list2 = new SinglyLinkedList();
        // creating second linked list1
        list2.addLast(6);
        list2.addLast(13);
        list2.addLast(10);
        list2.addLast(15);
        list2.addLast(30);

        System.out.println("The node of intersection is " + getIntersection(list1.head, list2.head));

    }

    public static Integer getIntersection(Node head1, Node head2) {

        Node firstList = head1;
        Node secondList = head2;
        int length1 = getLength(head1);
        int length2 = getLength(head2);

        int difference = Math.abs(length1 - length2);

        while (difference > 0) {
            if (length1 > length2) {
                firstList = firstList.next;
            } else {
                secondList = secondList.next;
            }
            difference--;
        }

        while (firstList.data != secondList.data) {

            firstList = firstList.next;
            secondList = secondList.next;
        }
        return (Integer) firstList.data;
    }

    public static int getLength(Node node) {

        if (node == null) {
            return 0;
        }
        return 1 + getLength(node.next);
    }
}