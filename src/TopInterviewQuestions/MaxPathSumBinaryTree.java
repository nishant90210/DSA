package TopInterviewQuestions;

public class MaxPathSumBinaryTree {

    private static int max_path_sum = Integer.MIN_VALUE;

    static class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

//        Node root = new Node(10);
//        root.left = new Node(2);
//        root.right = new Node(10);
//        root.left.left = new Node(20);
//        root.left.right = new Node(1);
//        root.right.right = new Node(-25);
//        root.right.right.left = new Node(3);
//        root.right.right.right = new Node(4);

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("maximum path sum is : " + findMaxSum(root));
    }

    private static int findMaxSum(Node root) {

        pathSum(root);
        return max_path_sum;
    }

    private static int pathSum(Node root) {

        if (root == null){
            return 0;
        }

        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        max_path_sum = Math.max(max_path_sum, left + right + root.data);
        return Math.max(left, right) + root.data;
    }
}
