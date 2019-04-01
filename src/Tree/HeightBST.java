package Tree;

/**
 * Created by NISHANT on 9/26/17.
 */

public class HeightBST {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(2);
        binaryTree.add(1);
        binaryTree.add(4);
        binaryTree.add(3);
        binaryTree.add(5);

        System.out.println("Height of tree is : " + maxHeight(binaryTree.root));

    }

    public static int maxHeight(Node root) {

        if (root == null){
            return 0;
        }
        else {
            int leftHeigth = maxHeight(root.left);
            int rightHeigth = maxHeight(root.right);
            return Math.max(leftHeigth, rightHeigth)+1;
        }
    }
}
