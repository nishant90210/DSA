package TopInterviewQuestions;

//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
public class HeightBalancedBST {

    /* |LeftSubTree Height - RightSubTree Height| <= 1  */

    public static void main(String[] args) {

        BurnBST.Node root = new BurnBST.Node(3);
        root.left = new BurnBST.Node(9);
        root.right = new BurnBST.Node(20);
        root.right.left = new BurnBST.Node(15);
        root.right.right = new BurnBST.Node(7);

        boolean balanced = isBalanced(root);
        System.out.println(balanced);
    }

    private static boolean isBalanced(BurnBST.Node root) {

        if (root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }


//    private static boolean isBalanced(BurnBST.Node root) {
//
//        if(root==null)
//            return true;
//
//        int lh = height(root.left);
//        int rh = height(root.right);
//
//        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
//            return true;
//        }
//        return false;
//    }


    public static int height(BurnBST.Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
