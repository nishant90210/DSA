package LinkedList;

/**
 * Created by NISHANT on 7/6/17.
 */
public class SwapNode {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    /* Function to add Node at beginning of list. This will insert the data from the opposite direction, piche se*/
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    public static void main(String[] args) {

        SwapNode swapNode = new SwapNode();
        swapNode.head = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        Node fifthNode = new Node(5);

        swapNode.head.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;
        System.out.print("Linked list before calling swapNodes() \n");
        swapNode.print();

        swapNode.swapNodes(2, 4);

        System.out.print("Linked list after calling swapNodes() \n");
        swapNode.print();
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

    public void swapNodes(int x, int y) {
        if (x == y){
            System.out.println("Nothing to swap");
            return;
        }
        Node currentX = head, prevX = null;
        while (currentX != null && currentX.data != x) {
            prevX = currentX;
            currentX = currentX.next;

        }

        Node currentY = head, prevY = null;
        while (currentY != null && currentY.data != x) {
            prevY = currentY;
            currentY = currentY.next;
        }

        if (currentX == null || currentY == null) {
            System.out.println("Element not present");
            return;
        }

        if (prevX != null){
            prevX.next = currentY;
        }
        else {
            head = currentY;
        }
        if (prevY != null){
            prevY.next = currentX;
        }
        else {
            head = currentX;
        }

        Node temp = currentX.next;
        currentX.next = currentY.next;
        currentY.next = temp;

    }
}