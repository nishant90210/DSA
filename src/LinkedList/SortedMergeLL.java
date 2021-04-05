package LinkedList;

/**
 * Created by NISHANT on 8/17/17.
 */
public class SortedMergeLL {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /* Function to add Node at beginning of list. This will insert the data from the opposite direction */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /* This function prints contents of linked list
       starting from  the given node */
    public void printList(Node node){
        if (node == null){
            System.out.println("Empty List");
        }else {
            while (node != null){
                System.out.print(node.data + " ");
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        SortedMergeLL llist = new SortedMergeLL();
        llist.push(30);
        llist.push(15);
        llist.push(10);
        llist.push(6);
        llist.push(5);

        SortedMergeLL llist2 = new SortedMergeLL();
        llist2.push(20);
        llist2.push(3);
        llist2.push(2);
        llist2.push(1);

        Node node = llist.mergeSortedLL(llist, llist2);
        llist.printList(node);
    }

    public Node mergeSortedLL(SortedMergeLL llist, SortedMergeLL llist2) {

        Node list1 = llist.head;
        Node list2 = llist2.head;
        Node finalList = new Node(0);
        Node temp = finalList;
        Node newNode;

        while (list1 != null && list2 != null){

            if (list1.data > list2.data) {
                newNode = new Node(list2.data);
                temp.next = newNode;
                list2 = list2.next;
            } else {
                newNode = new Node(list1.data);
                temp.next = newNode;
                list1 = list1.next;
            }
            temp = temp.next;
        }

        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return finalList.next;
    }

    //In-Place Recursion
    public Node sortedMergeInPlace(Node llist, Node llist2){

        if (llist == null){
            return llist2;
        }
        if (llist2 == null){
            return llist;
        }

        if (llist.data < llist2.data){
            llist.next = sortedMergeInPlace(llist.next, llist2);
            return llist;
        }else {
            llist2.next = sortedMergeInPlace(llist, llist2.next);
            return llist2;
        }
    }
}
