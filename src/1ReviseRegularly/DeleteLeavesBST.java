package Programs;

public class DeleteLeavesBST {

    public static void main(String[] args) {

        TrimBST.TreeNode root = new TrimBST.TreeNode(1);
        root.left = new TrimBST.TreeNode(2);
        root.right = new TrimBST.TreeNode(3);
        root.left.left = new TrimBST.TreeNode(2);
        root.right.left  = new TrimBST.TreeNode(2);
        root.right.right  = new TrimBST.TreeNode(4);
        removeLeafNodes(root, 2);
    }

    public static TrimBST.TreeNode removeLeafNodes(TrimBST.TreeNode root, int target) {

        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }
        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }
        if (root.left == null && root.right == null && root.val == target){
            return null;
        }else {
            return root;
        }
    }
}
