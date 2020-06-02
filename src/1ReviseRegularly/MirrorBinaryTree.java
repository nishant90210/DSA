package Tree;

/**
 * Created by NISHANT on 11/20/17.
 */
public class MirrorBinaryTree {

    static int result = 0;
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);

        findTilt(tree);
        System.out.println(result);
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        inOrder(tree);
        System.out.println("");

        /* convert tree to its mirror */
        mirror(tree);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        inOrder(tree);

    }

    private static int findTilt(Node root) {

        if (root == null){
            return 0;
        }
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        result += Math.abs(left - right);
        return left+right+root.data;
    }


    static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        /* do the subtrees */
        Node left = mirror(root.left);
        Node right = mirror(root.right);
        /* swap the left and right pointers */
        root.left = right;
        root.right = left;
        return root;
    }

    private static void inOrder(Node root) {

        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(" " + root.data);
        inOrder(root.right);
    }

}
