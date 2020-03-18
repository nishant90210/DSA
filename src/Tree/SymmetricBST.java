package Tree;

public class SymmetricBST {

    static class TreeNode {
        int val;
        public TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.right  = new TreeNode(3);
//        root.right.left  = new TreeNode(4);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right  = new TreeNode(3);

        boolean b = testSymmetry(root.left, root.right);
        System.out.println(b);
    }

    private static boolean testSymmetry(TreeNode leftSubTree, TreeNode rightSubTree) {

        if (leftSubTree == null && rightSubTree == null){
            return true;
        }else if (leftSubTree != null && rightSubTree != null){
            if (leftSubTree.val == rightSubTree.val){
                return (testSymmetry(leftSubTree.left, rightSubTree.right) && testSymmetry(leftSubTree.right, rightSubTree.left));
            }
        }
        return false;
    }
}
