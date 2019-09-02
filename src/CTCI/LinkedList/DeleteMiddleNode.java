package CTCI.LinkedList;

public class DeleteMiddleNode {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.appendToTail(1);
        linkedList.appendToTail(2);
        linkedList.appendToTail(56);
        linkedList.appendToTail(3);
        linkedList.appendToTail(4);
        linkedList.appendToTail(5);

        System.out.println("Before ");
        linkedList.displayList(linkedList.head);

        deleteMiddleNode(linkedList.head);

        System.out.println("After ");
        linkedList.displayList(linkedList.head);
    }

    private static void deleteMiddleNode(LinkedList.Node head) {

        LinkedList.Node slowPointer = head;
        LinkedList.Node fastPointer = head;
        LinkedList.Node prev = head;
        while (fastPointer.next.next != null){
            fastPointer = fastPointer.next.next;
            prev = slowPointer;
            slowPointer = slowPointer.next;
        }
        prev.next = slowPointer.next;
    }
}
