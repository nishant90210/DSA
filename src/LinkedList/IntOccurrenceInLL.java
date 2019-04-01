package LinkedList;

/**
 * Created by NISHANT on 8/16/17.
 */
public class IntOccurrenceInLL {

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

    public int countOccurence(int n){

        Node temp = head;
        int count = 0;
        while (temp != null){
            if(n == temp.data){
                count++;
            }
            temp = temp.next;
        }
        return count;
    }


    public static void main(String[] args) {
        IntOccurrenceInLL llist = new IntOccurrenceInLL();

        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(2);
        llist.push(4);
        llist.push(2);
        llist.push(5);

        System.out.println("Current Linked List is ");
        llist.printList();

        int number = llist.countOccurence(2);
        System.out.println("Number of Occurence of 2 is " + number);
    }

}
