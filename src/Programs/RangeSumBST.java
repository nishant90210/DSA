package Programs;

public class RangeSumBST {

    static ValidateBST.Node newTree = null;
    static ValidateBST.Node newRoot = new ValidateBST.Node(0);

    public static void main(String args[]) {
        ValidateBST.Node root1 = new ValidateBST.Node(1);
        root1.left = new ValidateBST.Node(3);
        root1.right = new ValidateBST.Node(2);
        root1.left.left = new ValidateBST.Node(5);
        root1.left.right = new ValidateBST.Node(6);


        ValidateBST.Node root2 = new ValidateBST.Node(2);
        root2.left = new ValidateBST.Node(1);
        root2.right = new ValidateBST.Node(3);
        root2.left.right = new ValidateBST.Node(4);
        root2.right.right = new ValidateBST.Node(7);

//        mergeTrees(root1, root2);
//
//        searchBST(root1, 3);

        increasingBST(root1);
    }

    public static ValidateBST.Node increasingBST(ValidateBST.Node root) {
        // In order traversal
        if(root == null) return null;
        ValidateBST.Node res = newRoot;
        inOrder(root);
        return res.right;
    }

    public static void inOrder(ValidateBST.Node root) {
        if(root == null) return;

        inOrder(root.left);
        newRoot.right = new ValidateBST.Node(root.data);
        newRoot = newRoot.right;
        inOrder(root.right);
    }


    private static ValidateBST.Node searchBST(ValidateBST.Node root, int val) {

        if(root == null){
            return null;
        }
        if(root.data == val){
            newTree = root;
        }
        searchBST(root.left, val);
        searchBST(root.right, val);
        return newTree;
    }

    public static ValidateBST.Node mergeTrees(ValidateBST.Node root1, ValidateBST.Node root2) {

        if (root1 == null && root2 == null){
            return null;
        }
        int val = (root1 == null ? 0 : root1.data) + (root2 == null ? 0 : root2.data);
        ValidateBST.Node newTree = new ValidateBST.Node(val);
        newTree.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newTree.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newTree;
    }
}
