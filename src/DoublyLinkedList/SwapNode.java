package DoublyLinkedList;

/**
 * Created by NISHANT on 9/4/17.
 */
public class SwapNode {

    Node head;

    static class Node{

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
            System.out.println("empty List");
        }
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SwapNode dllist = new SwapNode();

        dllist.push(6);
        dllist.push(5);
        dllist.push(4);
        dllist.push(3);
        dllist.push(2);
        dllist.push(1);

        System.out.println("Original Linked list ");
        dllist.print();

        System.out.println("After Linked list ");
        dllist.swapNodes(2);
        dllist.print();
    }

    public int countNodes(){

        Node temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void swapNodes(int k) {

        // Count nodes in linked list
        int n = countNodes();

        // Check if k is valid
        if (n < k){
            return;
        }
        // If x (kth node from start) and y(kth node from end)
        // are same
        if (2*k - 1 == n){
            return;
        }

        // Find the kth node from beginning of linked list.
        // We also find previous of kth node because we need
        // to update next pointer of the previous.
        Node x = head;
        Node x_prev = null;
        for (int i = 1; i < k ; i++){
            x_prev = x;
            x = x.next;
        }

        // Similarly, find the kth node from end and its
        // previous. kth node from end is (n-k+1)th node
        // from beginning
        Node y = head;
        Node y_prev = null;
        for (int i = 1; i < n-k+1 ; i++){
            y_prev = y;
            y = y.next;
        }
        // If x_prev exists, then new next of it will be y.
        // Consider the case when y->next is x, in this case,
        // x_prev and y are same. So the statement
        // "x_prev->next = y" creates a self loop. This self
        // loop will be broken when we change y->next.
        if (x_prev != null)
            x_prev.next = y;

        // Same thing applies to y_prev
        if (y_prev != null)
            y_prev.next = x;

        // TopInterviewQuestions.Swap next pointers of x and y. These statements
        // also break self loop if x->next is y or y->next
        // is x
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        // Change head pointers when k is 1 or n
        if (k == 1)
            head = y;

        if (k == n)
            head = x;
    }
}