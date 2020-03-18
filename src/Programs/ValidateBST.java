package Programs;

public class ValidateBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    private static boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data > max){
            return false;
        }
        boolean leftBST = isBST(root.left, min, root.data);
        boolean rightBST = isBST(root.right, root.data, max);
        if (!leftBST || !rightBST){
            return false;
        }
        return true;
    }
}
