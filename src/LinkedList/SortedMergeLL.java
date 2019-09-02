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
        llist.push(15);
        llist.push(10);
        llist.push(5);

        SortedMergeLL llist2 = new SortedMergeLL();
        llist2.push(20);
        llist2.push(3);
        llist2.push(2);

        Node node = llist.sortedMerge(llist, llist2);
        llist.printList(node);
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


    //With Space
    public Node sortedMerge(SortedMergeLL llist, SortedMergeLL llist2){

        Node temp = new Node(0);
        Node finalList = temp;
        Node l1 = llist.head;
        Node l2 = llist2.head;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                if(l1.data < l2.data){
                    temp.next = l1;
                    l1 = l1.next;
                }
                else {
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }
            else if (l1 == null){
                temp.next = l2;
                break;
            }
            else if (l2 == null){
                temp.next = l1;
                break;
            }
        }
        return finalList.next;
    }
}
