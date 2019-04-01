package LinkedList;

/**
 * Created by NISHANT on 8/8/17.
 */
public class NthFromEndLLIst {

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

    public static void main(String[] args) {
        NthFromEndLLIst llist = new NthFromEndLLIst();
        for (int i=5; i>0; --i)
        {
            llist.push(i);
        }
        llist.printList();
        llist.nthFromEnd(4);
    }

    private int getLength(Node head) {

        Node temp = head;
        int count = 0;
        if (temp == null){
            System.out.println("Empty List");
        }else {
            while (temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }
        return count;
    }

    private void nthFromEnd(int n) {

        NthFromEndLLIst nthFromEndLLIst = new NthFromEndLLIst();
        Node node = head;
        int length = nthFromEndLLIst.getLength(node);
        for (int i = 1; i < length-n+1; i++){
            node = node.next;
        }
        System.out.println(node.data);
    }
}