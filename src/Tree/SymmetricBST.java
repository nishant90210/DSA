package Tree;

public class SymmetricBST {

    static class TreeNode {
        int val;
        public TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right  = new TreeNode(3);
        root.right.left  = new TreeNode(4);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right.right  = new TreeNode(3);

        boolean b = testSymmetry(root.left, root.right);
        System.out.println(b);
    }

    private static boolean testSymmetry(TreeNode leftSubTree, TreeNode rightSubTree) {

        if (leftSubTree == null && rightSubTree == null){
            return true;
        }
        // return true if
        // 1. both trees are non-empty and
        // 2. left subtree is mirror image of right subtree and
        // 3. right subtree is mirror image of left subtree
        return (leftSubTree != null && rightSubTree != null) &&
                testSymmetry(leftSubTree.left, rightSubTree.right) &&
                testSymmetry(leftSubTree.right, rightSubTree.left);
    }
}
