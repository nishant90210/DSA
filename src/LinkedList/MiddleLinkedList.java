package LinkedList;

/**
 * Created by NISHANT on 8/8/17.
 */
public class MiddleLinkedList {

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
    public void printList()
    {
        Node node = head;
        while (node != null)
        {
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void printMiddle(){

        Node slow_pointer = head;
        Node fast_pointer = head;

        if (head != null){
            while (fast_pointer != null && fast_pointer.next != null){
                fast_pointer = fast_pointer.next.next;
                slow_pointer = slow_pointer.next;
            }
            System.out.println("The middle element is [" + slow_pointer.data + "] \n");
        }
    }

    public int printMiddleByCounting(){

        int mid;
        int count = 0;
        Node node = head;
        if (node == null){
            System.out.println("Empty List");
        }else {
            while (node != null){
                node = node.next;
                count ++;
            }
        }
        mid = count/2;
        int newCount = 0;
        System.out.println("mid element " + mid);
        node = head;
        while (node != null){
            node = node.next;
            newCount++;
            if (mid == newCount){
                System.out.println("Middle Element Value is = " + node.data);
                break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        MiddleLinkedList llist = new MiddleLinkedList();
        for (int i=6; i>0; --i)
        {
            llist.push(i);
            llist.printList();
//            llist.printMiddle();
        }
//        System.out.println("Count is " + llist.printMiddleByCounting());
        llist.printMiddle();
    }

}
