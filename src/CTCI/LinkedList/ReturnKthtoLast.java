package CTCI.LinkedList;

public class ReturnKthtoLast {

    public static void main(String[] args) {

        int n = 0;
        LinkedList linkedList = new LinkedList();

        linkedList.appendToTail(20);
        linkedList.appendToTail(4);
        linkedList.appendToTail(15);
        linkedList.appendToTail(35);

        System.out.println("Before ");
        linkedList.displayList(linkedList.head);

        kthFromLast(linkedList.head, n);
        kthFromLastIterative(linkedList.head, n);
    }

    //Recursive solution
    private static int kthFromLast(LinkedList.Node head, int n) {

        if (head == null){
            return 0;
        }
        int index = kthFromLast(head.next, n) + 1;
        if (index == n){
            System.out.println("Printing the nth Node from the end recursively " + head.data);
        }
        return index;
    }


    //Iterative Solution
    //Take 2 pointer current and runner, make runner go until its equal to 'n' and then move 'current' and 'runner'
    //until 'runner's next' is null after exiting the while loop print the data
    private static void kthFromLastIterative(LinkedList.Node head, int n) {

        int count = 0;
        boolean moveCurrent = false;
        LinkedList.Node current = head;
        LinkedList.Node runner = head;
        while (runner.next != null){
            runner = runner.next;
            count++;
            if (count == n){
                moveCurrent = true;
            }
            if (moveCurrent){
                current = current.next;
            }
        }
        if (moveCurrent){
            System.out.println("Printing the nth Node from the end iteratively " + current.data);
        }
    }
}
