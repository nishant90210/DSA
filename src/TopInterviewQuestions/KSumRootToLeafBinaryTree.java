package TopInterviewQuestions;

public class KSumRootToLeafBinaryTree {

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

        int sum = 18;
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        if (hasPathSum(root, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
    }

    private static boolean hasPathSum(Node root, int sum) {

        if (root == null){
            return false;
        }
        else if (root.left == null && root.right == null && sum - root.data == 0){
            return true;
        }else {
            return (hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data));
        }
    }
}
