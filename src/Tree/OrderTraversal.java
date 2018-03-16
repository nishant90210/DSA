package Tree;

import java.util.Stack;

/**
 * Created by NISHANT on 9/26/17.
 */

class BinaryTree {

    Node root;

    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    public BinaryTree() {
        this.root = null;
    }


    public void printPreorder(Node root) {

        if (root == null){
            return;
        }else {
            System.out.print(" " + root.data);
            if (root.left != null){
                printPreorder(root.left);
            }
            if (root.right != null){
                printPreorder(root.right);
            }
        }
    }

    public void printPreorderUsingStack(Node root) {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.print(pop.data + " ");
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    public void printInorder(Node root) {

        if (root == null){
            return;
        }else {
            if (root.left != null){
                printInorder(root.left);
            }
            System.out.print(" " + root.data);
            if (root.right != null){
                printInorder(root.right);
            }
        }
    }

    public void printInorderUsingStack(Node root) {

        if (root == null){
            return;
        }else {
            Stack<Node> stack = new Stack<>();
            Node currentNode = root;
            while (true){
                while (currentNode != null){
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
                while (!stack.isEmpty() && currentNode == null){
                    Node pop = stack.pop();
                    System.out.print(pop.data + " ");
                    currentNode = pop.right;
                }
                if (stack.isEmpty() && currentNode == null) {
                    break;
                }
            }
        }
    }



//    public void printPostorder(Node root) {
//
//        if (root == null){
//            return;
//        }else {
//            if (root.left != null){
//                printPostorder(root.left);
//            }
//            if (root.right != null){
//                printPostorder(root.right);
//            }
//            System.out.print(" " + root.data);
//        }
//    }
//  4 12 10 18 24 22 15 31 44 35 66 90 70 50 25

    public void printPostorder(Node root) {

        Stack<Node> firstStack = new Stack<>();
        Stack<Node> secondStack = new Stack<>();
        firstStack.push(root);
        if (root == null){
            return;
        }else {
            while (!firstStack.isEmpty()){
                Node pop = firstStack.pop();
                secondStack.push(pop);
                if (pop.left != null){
                    firstStack.push(pop.left);
                }
                if (pop.right != null){
                    firstStack.push(pop.right);
                }
            }
            while (!secondStack.isEmpty()){
                System.out.print(" " + secondStack.pop().data);
            }
        }
    }



    public void add(int nodeToAdd) {

        Node node = new Node(nodeToAdd);
        if (root == null){
            root = node;
            System.out.println("Root " + root.data);
        }else {
            traverseAndAddNode(root, node);
        }
    }

    private void traverseAndAddNode(Node root, Node nodeToAdd) {

        if (nodeToAdd.data > root.data){
            if (root.right == null){
                root.right = nodeToAdd;
                System.out.println("Right Child " + nodeToAdd.data);
            }else {
                traverseAndAddNode(root.right, nodeToAdd);
            }
        }else {
            if (root.left == null){
                root.left = nodeToAdd;
                System.out.println("Left Child " + nodeToAdd.data);
            }else {
                traverseAndAddNode(root.left, nodeToAdd);
            }
        }
    }
}


public class OrderTraversal {

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
//        tree.root = new Node(1);
//        tree.root.left = new Node(2);
//        tree.root.right = new Node(3);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(5);

        tree.add(25);
        tree.add(15);
        tree.add(50);
        tree.add(10);
        tree.add(22);
        tree.add(35);
        tree.add(70);
        tree.add(4);
        tree.add(12);
        tree.add(18);
        tree.add(24);
        tree.add(31);
        tree.add(44);
        tree.add(66);
        tree.add(90);

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);

        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);

        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
    }
}