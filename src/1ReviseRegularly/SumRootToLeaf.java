package TopInterviewQuestions;

public class SumRootToLeaf {

    static class Node {

        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        int val = 0;
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(getSum(root, val));
    }

    private static int getSum(Node root, int val) {

        if (root == null) {
            return 0;
        }
        val = val * 10 + root.val;
        if (root.left == null || root.right == null){
            return val;
        }
        return getSum(root.left, val) + getSum(root.right, val);
    }
}
