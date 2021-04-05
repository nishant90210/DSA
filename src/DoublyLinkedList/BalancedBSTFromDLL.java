package DoublyLinkedList;

import Tree.Node;

import java.util.LinkedList;

public class BalancedBSTFromDLL {

    static Node root;

    public static void main(String[] args)
    {
        BalancedBSTFromDLL balancedBSTFromDLL = new BalancedBSTFromDLL();
        LinkedList<Integer> llist = new LinkedList<Integer>();

        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        int rootElement = searchLLMid(llist);
        Node node = new Node(rootElement);
        root = node;
        balancedBSTFromDLL.buildLeftTree(llist);
        balancedBSTFromDLL.buildRightTree(llist);
        balancedBSTFromDLL.printInorder(root);
    }

    public void printInorder(Node root) {

        if (root == null){
            return;
        }else {
            System.out.print(" " + root.data);
            if (root.left != null){
                printInorder(root.left);
            }
            if (root.right != null){
                printInorder(root.right);
            }
        }
    }

    private void buildRightTree(LinkedList<Integer> llist) {

        for (int i = llist.size()/2+1; i < llist.size(); i++) {
            traverseAndAdd(root, llist.get(i));
        }
    }

    private void buildLeftTree(LinkedList<Integer> llist) {

        for (int i = 0; i < llist.size()/2; i++) {
            traverseAndAdd(root, llist.get(i));
        }
    }

    private void traverseAndAdd(Node root, Integer val) {

        if (root.data > val){
            if (root.left == null){
                root.left = new Node(val);
            }else {
                traverseAndAdd(root.left, val);
            }
        }else {
            if (root.right == null){
                root.right = new Node(val);
            }else {
                traverseAndAdd(root.right, val);
            }
        }
    }

    private static int searchLLMid(LinkedList llist) {

        int mid = llist.size()/2;
        return (int)llist.get(mid);
    }

    /*
        Step 1. Calculate the length of the linked list.
        Step 2. Recursively create left sub tree from first half nodes.
        Step 3. Make middle node as the root and node returned from previous call (Step 2) as left child of the root.
        Step 4. Move head to next node.
        Step 5. Recursively create the right sub tree from second half nodes.
        Step 6. Return root.


        private ListNode convertDllToBST(int len) {
        if (len == 0) {
            return null;
        }

        ListNode left = convertDllToBST(len / 2);
        ListNode root = head;
        root.prev = left;
        head = head.next;
        ListNode right = convertDllToBST(len - (len / 2) - 1);
        root.next = right;
        return root;
    }
     */

}
