package DoublyLinkedList;

import Tree.Node;

public class DLLFromBinaryTree {

    Node root;
    Node head;
    Node prev = null;

    public static void main(String[] args) {
        // Let us create the tree as shown in above diagram
        DLLFromBinaryTree tree = new DLLFromBinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        tree.printInOrder(tree.root);
        // convert to DLL
        tree.binaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);

    }

    private void printInOrder(Node root) {

        if (root == null) {
            return;
        } else {
            if (root.left != null) {
                printInOrder(root.left);
            }
            System.out.print(" " + root.data);
            if (root.right != null) {
                printInOrder(root.right);
            }
        }
    }

    private void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    private void binaryTree2DoubleLinkedList(Node root) {

        // Base case
        if (root == null) {
            return;
        }
        // Recursively convert right subtree
        binaryTree2DoubleLinkedList(root.right);

        // insert root into DLL
        root.right = head;

        // Change left pointer of previous head
        if (head != null) {
            head.left = root;
        }

        // Change head of Doubly linked list
        head = root;

        // Recursively convert left subtree
        binaryTree2DoubleLinkedList(root.left);
    }
}