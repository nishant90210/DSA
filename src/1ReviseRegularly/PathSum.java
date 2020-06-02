package Programs;

public class PathSum {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        boolean b = hasPathSum(root, 22);
        System.out.println(b);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        } else if (root.left == null && root.right == null && sum - root.val == 0){
            return true;
        } else {
            boolean left = hasPathSum(root.left, sum - root.val);
            boolean right = hasPathSum(root.right, sum - root.val);
            return left || right;
        }
    }
}
