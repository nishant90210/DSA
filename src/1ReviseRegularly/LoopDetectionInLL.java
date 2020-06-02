package LinkedList;

/**
 * Created by NISHANT on 8/16/17.
 */
public class LoopDetectionInLL {

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
    public void push(int new_data) {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /* This function prints contents of linked list
       starting from  the given node */
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public void detectLoop() {
        Node slow_pointer = head;
        Node fast_pointer = head;
        while ( fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                System.out.println("Loop exists in Linked List");
                break;
            }
        }
        slow_pointer = head;
        while (slow_pointer != null && slow_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next;
            if (slow_pointer == fast_pointer) {
                System.out.println("Loop exists at " + slow_pointer.data);
                break;
            }
        }
        if (slow_pointer == fast_pointer) { //if condition executed if loop exist

            slow_pointer = head;
            while (slow_pointer != fast_pointer.next) {
                slow_pointer = slow_pointer.next;
                fast_pointer = fast_pointer.next;
            }

            fast_pointer.next = null; // removing loop
        }
    }

    public static void main(String[] args) {

        LoopDetectionInLL llist = new LoopDetectionInLL();

        llist.head = new Node(50);
        llist.head.next = new Node(20);
        llist.head.next.next = new Node(15);
        llist.head.next.next.next = new Node(4);
        llist.head.next.next.next.next = new Node(10);

        llist.head.next.next.next.next.next = llist.head.next.next;


//        llist.head = new Node(1);
//        Node secondNode = new Node(2);
//        Node thirdNode = new Node(3);
//        Node fourthNode = new Node(4);
//        Node fifthNode = new Node(5);
//        Node sixthNode = new Node(6);
//        Node seventhNode = new Node(7);
//
//        llist.head.next = secondNode;
//        secondNode.next = thirdNode;
//        thirdNode.next = fourthNode;
//        fourthNode.next = fifthNode;
//        fifthNode.next = sixthNode;
//        sixthNode.next = seventhNode;

//        llist.push(20);
//        llist.push(4);
//        llist.push(15);
//        llist.push(10);

        /*Create loop for testing */
//        llist.head.next.next.next.next = llist.head;
//        llist.printList();
        llist.detectLoop();
        llist.printList();
    }
}
