package DoublyLinkedList;

/**
 * Created by NISHANT on 8/28/17.
 */
public class DLLAddExample {

    Node head;

    static class Node {

        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }


    //Adding a node at the front of the list
    public void push(int new_data) {
    /* 1. allocate node
    * 2. put in the data */
    Node new_Node = new Node(new_data);

    /* 3. Make next of new node as head and previous as NULL */
    /* previous is already null */
        new_Node.next = head;

    /* 4. change prev of head node to new node */
        if (head != null)
            head.previous = new_Node;

    /* 5. move the head to point to the new node */
        head = new_Node;
    }

    public void print(){
        Node temp = head;
        if (temp == null){
            System.out.println("Empty List");
        }
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

//    public static void main(String[] args)
//    {
//        /* Start with the empty list */
//        DLL dll = new DLL();
//
//        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
//        dll.push(7);
//
//        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
//        dll.push(1);
//        dll.push(3);
//        dll.push(5);
//        dll.push(8);
//
//        System.out.println("Created DLL is: ");
//        dll.print();
//    }

    /* Add Node with Different Style */
    public static void main(String[] args) {

        DLLAddExample dllNode = new DLLAddExample();
        dllNode.head = new Node(1);

        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);

        dllNode.head.previous = null;
        dllNode.head.next = secondNode;

        secondNode.previous = dllNode.head;
        secondNode.next = thirdNode;

        thirdNode.previous = secondNode;
        thirdNode.next = fourthNode;

        fourthNode.previous = thirdNode;
        fourthNode.next = fifthNode;

        fifthNode.previous = fourthNode;
        fifthNode.next = fifthNode;

        fifthNode.previous = fourthNode;
        fifthNode.next = null;

//        dllNode.addFirst(7);
//        dllNode.addLast(9);
        dllNode.afterGivenNode(thirdNode, 8);
        dllNode.print();

    }

    public void addFirst(int data){

        Node node = new Node(data);
        node.next = head;
        head.previous = node.next;
        node.previous = null;
        head = node;

    }

    public void addLast(int data){

        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        }
        Node lastNode = head;
        while (lastNode.next != null){
            lastNode = lastNode.next;
        }
        newNode.next = null;
        newNode.previous = lastNode.next;
        lastNode.next = newNode;

        System.out.println("data "  + lastNode.next.data);
    }

    public void afterGivenNode(Node givenNode,int data){

        Node newNode = new Node(data);
        if (givenNode == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
        newNode.next = givenNode.next;
        givenNode.next = newNode;
        newNode.previous = givenNode;
        if(newNode.next != null){
            givenNode.next.previous = newNode.next;
        }
    }
}