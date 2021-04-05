package TopInterviewQuestions;

public class MaxSumRootToLeafPath {

    static int maxSum = Integer.MIN_VALUE;
    static Node maxLeaf=null;

    // Data structure to store a Binary Tree node
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to print root-to-leaf path having given sum in a binary tree
    public static boolean printPath (Node root, int sum) {
        // base case
        if (sum == 0) {
            return true;
        }

        // base case
        if (root == null) {
            return false;
        }

        // recur for left and right subtree with reduced sum
        boolean left = printPath(root.left, sum - root.data);
        boolean right = printPath(root.right, sum - root.data);

        // print current node if it lies on path having given sum
        if (left || right) {
            System.out.print(root.data + " ");
        }

        return left || right;
    }

    // Function to calculate maximum root-to-leaf sum in a binary tree
    public static void rootToLeafSum(Node root, int sum) {
        if (root != null) {
            sum = sum + root.data;
            if (sum > maxSum && root.left == null && root.right == null) {
                maxSum = sum;
            }
            System.out.println("Sum " + sum);
            rootToLeafSum(root.left, sum);
            rootToLeafSum(root.right, sum);
        }
    }

    // Function to print maximum sum root-to-leaf path in a given binary tree
    public static void findMaxSumPath(Node root)
    {
        rootToLeafSum(root, 0);
        System.out.println("Maximum sum is " + maxSum);
        System.out.println("Maximum sum path is: ");

        printPath(root, maxSum);
    }

    // main function
    public static void main(String[] args)
    {
        Node root = null;
	    /* Construct below tree
		          1
		       /     \
		      2       3
		     / \     / \
		    8   4   5   6
		       /   / \   \
		     10   7   9   5
	    */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(10);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(9);
        root.right.right.right  = new Node(5);

        findMaxSumPath(root);
    }
}
