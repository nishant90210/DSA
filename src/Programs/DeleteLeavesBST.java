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
        if(root.left == null && root.val == target){
            root.left = null;
        }
        removeLeafNodes(root.left, target);
        if(root.right == null && root.val == target){
            root = null;
        }
        removeLeafNodes(root.right, target);
        return root;
    }
}
