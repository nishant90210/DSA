package Programs;

import TopInterviewQuestions.MaxPathSumBinaryTree;

public class BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {

        MaxPathSumBinaryTree.Node root = new MaxPathSumBinaryTree.Node(-10);
        root.left = new MaxPathSumBinaryTree.Node(9);
        root.right = new MaxPathSumBinaryTree.Node(20);
        root.right.left = new MaxPathSumBinaryTree.Node(15);
        root.right.right = new MaxPathSumBinaryTree.Node(7);

        findMaxSum(root);
        System.out.println("maximum path sum is : " + maxSum);
    }

    private static int findMaxSum(MaxPathSumBinaryTree.Node root) {

        if (root == null){
            return 0;
        }
        maxSum = Math.max(maxSum, findMaxSum(root.left) + findMaxSum(root.right) + root.data);
        return Math.max(findMaxSum(root.left), findMaxSum(root.right)) + root.data;
    }
}
