package LinkedList;

/**
 * Created by NISHANT on 4/25/18.
 */
public class Reverse {

    Node head;

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){

        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public void printList() {

        Node node = head;
        while (node!= null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Reverse llist = new Reverse();
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);

        llist.printList();
        Node node = llist.reverseList();
        System.out.println();
        llist.printList(node);
    }

    public Node reverseList() {

        Node currentNode = head;
        Node previousNode=null, nextNode;
        while(currentNode!=null) {

            nextNode=currentNode.next;
            // reversing the link
            currentNode.next=previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode=currentNode;
            currentNode=nextNode;
        }
        return previousNode;
    }

    public void printList(Node node) {

        Node root = node;
        while (root!= null){
            System.out.print(root.data + " ");
            root = root.next;
        }
    }
}
