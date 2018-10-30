package LinkedList;

import Tree.Node;

import java.util.LinkedList;

public class BSTFromSortedLL {

    static LNode head;

    class LNode {
        int data;
        LNode next, prev;

        public LNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        BSTFromSortedLL llist = new BSTFromSortedLL();

        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        Node node = llist.buildTree(7);
        llist.printPreOrder(node);

    }

    private void push(int i) {

        LNode node = new LNode(i);
        node.prev = null;
        node.next = head;
        if (head != null){
            head.prev = node;
        }
        head = node;
    }

    public void printPreOrder(Node root) {

        if (root == null){
            return;
        }else {
            System.out.print(" " + root.data);
            if (root.left != null){
                printPreOrder(root.left);
            }
            if (root.right != null){
                printPreOrder(root.right);
            }
        }
    }

    private Node buildTree(int size) {

        if (size <= 0){
            return null;
        }
        Node left = buildTree(size/2);
        Node root = new Node(head.data);
        root.left = left;
        head = head.next;
        root.right = buildTree(size - size/2 -1);
        return root;
    }
}
