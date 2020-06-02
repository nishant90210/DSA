package DoublyLinkedList;

/**
 * Created by NISHANT on 8/28/17.
 */
public class DLLAddExample {

    Node head;
    static class Node {

        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        DLLAddExample dll = new DLLAddExample();
        dll.addInLast(2);
        dll.addInFront(7);
        dll.addInFront(6);
        dll.addInLast(5);
        dll.addInLast(3);
        dll.addInLast(1);
        dll.afterGivenNode(5, 4);
        dll.print();
    }

    private void afterGivenNode(int afterThisNode, int nodeToBeAdded) {

        Node temp = head;
        Node newNode = new Node(nodeToBeAdded);
        while (temp != null){
            if (temp.data == afterThisNode){
                newNode.next = temp.next;
                temp.next.prev = newNode;
                temp.next = newNode;
                newNode.prev = temp;
                return;
            }
            temp = temp.next;
        }
    }

    private void addInLast(int nodeData) {

        Node last = head;
        Node newNode = new Node(nodeData);
        if (head == null){
            head = newNode;
            return;
        }
        while (last.next != null){
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    private void print() {

        Node temp = head;
        while (temp != null) {

            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    private void addInFront(int nodeData) {

        Node newNode = new Node(nodeData);
        if (head == null){
            head = newNode;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }
}