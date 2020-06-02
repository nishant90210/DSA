package Programs;

import TopInterviewQuestions.KSumRootToLeafBinaryTree;

public class SumRoottoLeafNumbers {

    static int sum = 0;
    public static void main(String[] args) {

        KSumRootToLeafBinaryTree.Node root = new KSumRootToLeafBinaryTree.Node(4);
        root.left = new KSumRootToLeafBinaryTree.Node(9);
        root.right = new KSumRootToLeafBinaryTree.Node(0);
        root.left.left = new KSumRootToLeafBinaryTree.Node(5);
        root.left.right = new KSumRootToLeafBinaryTree.Node(1);
        int i = sumNumbers(root, sum);
        System.out.println(i);
    }

    public static int sumNumbers(KSumRootToLeafBinaryTree.Node root, int sum) {

        if(root == null){
            return 0;
        }
        if (root.left == null & root.right == null){
            return sum*10 + root.data;
        }
        int leftSum = sumNumbers(root.left, sum * 10 + root.data);
        int rightSum = sumNumbers(root.right, sum * 10 + root.data);
        int total = leftSum + rightSum;
        return total;
    }
}
