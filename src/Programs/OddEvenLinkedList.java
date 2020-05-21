package Programs;

public class OddEvenLinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    public static void main(String[] args) {

        int num = 5;
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        for (int i = num; i > 0; i--) {
            oddEvenLinkedList.push(i);
        }
        oddEvenLinkedList.oddEvenList(oddEvenLinkedList.head);
    }

    public Node oddEvenList(Node head) {

        if (head == null){
            return null;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null){

            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}


















