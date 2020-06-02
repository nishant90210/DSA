package Tree;

/**
 * Created by NISHANT on 11/1/17.
 */
//LCA in BINARY TREE
public class LowestCommonAncestorBST {

    static class Node {
        int val;
        public Node left;
        Node right;
        Node(int x) { val = x; }
    }

    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        root.left.left = new Node(0);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(5);

        System.out.println(lowestCommonAncestor(root, 8, 9).val);
    }

    private static Node lowestCommonAncestor(Node root, int phal, int phool) {

        if (phal < root.val && phool < root.val){
            return lowestCommonAncestor(root.left, phal, phool);
        }
        if (phal > root.val && phool > root.val){
            return lowestCommonAncestor(root.right, phal, phool);
        }
        return root;
    }
}
