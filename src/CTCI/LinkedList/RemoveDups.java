package CTCI.LinkedList;

import java.util.HashSet;

//Write code to remove duplicates from an unsorted linked list
public class RemoveDups {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.appendToTail(12);
        linkedList.appendToTail(11);
        linkedList.appendToTail(11);
        linkedList.appendToTail(11);
        linkedList.appendToTail(12);
        linkedList.appendToTail(11);
        linkedList.appendToTail(10);

        linkedList.displayList(linkedList.head);

//        removeDuplicates(linkedList.head);
        removeDuplicatesWithoutSpace(linkedList.head);

        System.out.println("After removing");
        linkedList.displayList(linkedList.head);
    }

    //O(N^2), without space
    private static void removeDuplicatesWithoutSpace(LinkedList.Node head) {

        LinkedList.Node current = head;
        while (current != null){
            LinkedList.Node runner = current;
            while (runner.next != null){
                if (runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //O(N), with space
    private static void removeDuplicates(LinkedList.Node list) {

        HashSet<Integer> set = new HashSet<>();
        LinkedList.Node previous = null;
        while (list != null){
            if (set.contains(list.data)){
                previous.next = list.next;
            }else {
                set.add(list.data);
                previous = list;
            }
            list = list.next;
        }
    }
}
