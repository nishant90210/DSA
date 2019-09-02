package LinkedList;

import Tree.Node;

public class BSTFromSortedLL {

    static LNode head;

    class LNode {
        int data;
        LNode next;

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

        printll(head);

        int size = calculateSizeOfll(head);
//        System.out.println(size);
        int[] arr = {1,2,3,4,5,6,7};
        int start = 0;
        int length = arr.length;
        Node node = llist.buildTree(arr, start, length-1);
        System.out.println();
        System.out.println("Printing the pre order ");
        llist.printPreOrder(node);
        System.out.println();
        System.out.println("Printing the In order ");
        llist.printInOrder(node);

    }

    private void printInOrder(Node node) {

        if (node == null){
            return;
        }
        if (node.left != null){
            printInOrder(node.left);
        }
        System.out.print(node.data + " ");
        if (node.right != null){
            printInOrder(node.right);
        }
    }

    private static int calculateSizeOfll(LNode head) {

        int count = 0;
        if (head == null){
            return count;
        }
        while (head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    private static void printll(LNode llist) {

        if(llist == null){
            return;
        }else {
            while (llist != null){
                System.out.print(llist.data + " ");
                llist = llist.next;
            }
        }
    }

    private void push(int i) {

        LNode new_Node = new LNode(i);
        new_Node.next = head;
        head = new_Node;
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

    private Node buildTree(int[] arr, int start, int end) {

        if (start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);
        node.left = buildTree(arr, start, mid-1);
        node.right = buildTree(arr, mid+1, end);
        return node;
    }

    //Bottom up approach for BST
//    private Node buildTree(int size) {
//
//        if (size <= 0){
//            return null;
//        }
//        Node left = buildTree(size/2); //Need to reach 0 level for insertion of first element thats y size/2
//        Node root = new Node(head.data);
//        root.left = left;
////        System.out.println("Printing left "+ left);
//        head = head.next;
//        root.right = buildTree(size - size/2 -1);
//        return root;
//    }
}
