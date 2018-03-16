package LinkedList;

/**
 * Created by NISHANT on 6/21/17.
 */
public class SimpleLinkedListWith3Nodes {

    Node head; // head of list

    /* Linked list Node.  This inner class is made static so that
       main() can access it */
    static class Node {

        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        /* Start with the empty list. */
        SimpleLinkedListWith3Nodes simpleLinkedListWith3Nodes = new SimpleLinkedListWith3Nodes();
        simpleLinkedListWith3Nodes.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);

        /* Three nodes have been allocated  dynamically.
          We have refernces to these three blocks as first,
          second and third

           list.head        second              third
             |                |                  |
             |                |                  |
         +----+------+     +----+------+     +----+------+
         | 1  | null |     | 2  | null |     |  3 | null |
         +----+------+     +----+------+     +----+------+ */

        simpleLinkedListWith3Nodes.head.next = secondNode;  // Link first node with the second node

        /*  Now next of first Node refers to second.  So they
            both are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  | null |     |  3 | null |
        +----+------+     +----+------+     +----+------+ */

        secondNode.next = thirdNode;    // Link second node with the third node

         /*  Now next of second Node refers to third.  So all three
            nodes are linked.

         llist.head        second              third
            |                |                  |
            |                |                  |
        +----+------+     +----+------+     +----+------+
        | 1  |  o-------->| 2  |  o-------->|  3 | null |
        +----+------+     +----+------+     +----+------+ */

        simpleLinkedListWith3Nodes.addFront();
        simpleLinkedListWith3Nodes.addLast();
        simpleLinkedListWith3Nodes.afterGivenNode(secondNode);
        simpleLinkedListWith3Nodes.printList();
    }

    /* This function prints contents of linked list starting from head */
    public void printList(){

        Node n = head;
        while (n != null){
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void addFront(){

        Node node = new Node(4);
        node.next = head;
        head = node;
    }

    public void addLast(){

        Node newNode = new Node(5);
        if (head == null){
            head = newNode;
        }
        Node lastNode = head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void afterGivenNode(Node givenNode){
        Node newNode = new Node(6);
        if (givenNode == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }

        newNode.next = givenNode.next;
        givenNode.next = newNode;
    }

}